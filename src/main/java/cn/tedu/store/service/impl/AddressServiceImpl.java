package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.IDistrictService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressMapper addressMapper;

	@Autowired
	private IDistrictService districtService;

	private void addnew(Address address) {
		Integer rows = addressMapper.addnew(address);
		if (rows != 1) {
			throw new InsertException("增加地址时出现未知错误，请稍后重试");
		}
	}

	private Integer getCountByUid(Integer uid) {
		return addressMapper.getCountByUid(uid);
	}

	private List<Address> findByUid(Integer uid) {
		return addressMapper.findByUid(uid);
	}

	private void updateNonDefault(Integer uid, String modifiedUser, Date modifiedTime) {
		Integer rows = addressMapper.updateNonDefault(uid, modifiedUser, modifiedTime);
		if (rows == 0) {
			throw new UpdateException("修改数据时出现未知错误");
		}
	}

	private void updateDefault(Integer id, String modifiedUser, Date modifiedTime) {
		Integer rows = addressMapper.updateDefault(id, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("修改数据时出现未知错误");
		}
	}

	private Address findById(Integer id) {
		return addressMapper.findById(id);
	}

	private void deleteById(Integer id) {
		Integer rows = addressMapper.deleteById(id);
		if (rows != 1) {
			throw new DeleteException("数据删除异常");
		}
	}

	private Address findByLastModified(Integer uid) {
		return addressMapper.findByLastModified(uid);
	}

	/**
	 * 通过省/市/区代号获取名称
	 * 
	 * @param province
	 *            省代号
	 * @param city
	 *            市代号
	 * @param area
	 *            区代号
	 * @return 省市区名称
	 */
	private String getDistrict(String province, String city, String area) {
		District p = districtService.getByCode(province);
		District c = districtService.getByCode(city);
		District a = districtService.getByCode(area);
		String provinceName = null;
		if (p != null) {
			provinceName = p.getName();
		}
		String cityName = null;
		if (p != null) {
			cityName = c.getName();
		}
		String areaName = null;
		if (p != null) {
			areaName = a.getName();
		}
		return provinceName + cityName + areaName;
	}

	@Override
	public Address create(Address address, String username) throws InsertException {
		// 获取district数据
		String district = getDistrict(address.getProvince(), address.getCity(), address.getArea());
		// 封装数据
		address.setDistrict(district);
		Integer count = getCountByUid(address.getUid());
		address.setIsDefault(count == 0 ? 1 : 0);
		Date now = new Date();
		address.setCreatedUser(username);
		address.setCreatedTime(now);
		address.setModifiedUser(username);
		address.setModifiedTime(now);
		addnew(address);
		return address;
	}

	@Override
	public List<Address> getListByUid(Integer uid) {
		return findByUid(uid);
	}

	@Override
	// transactional 开启事务 保证一系列数据操作能同时成功或失败 一般用在数据库两次以上增删改操作
	@Transactional
	public void setDefault(Integer id, Integer uid, String username) {
		Address address = findById(id);
		if (address == null) {
			throw new AddressNotFoundException("设置默认收货地址失败，尝试访问收货地址数据不存在");
		}
		if (address.getUid() != uid) {
			throw new AccessDeniedException("非法访问异常");
		}
		updateNonDefault(uid, username, new Date());
		updateDefault(id, username, new Date());
	}

	@Override
	@Transactional
	public void delete(Integer id, Integer uid, String username) {
		// 获取将要删除的数据
		Address address = findById(id);
		// 判断该数据是否存在，若不存在则抛出异常
		if (address == null) {
			throw new AddressNotFoundException("设置默认收货地址失败，尝试访问收货地址数据不存在");
		}
		// 判断该数据是否是该用户的收货地址
		if (address.getUid() != uid) {
			throw new AccessDeniedException("非法访问异常");
		}
		// 删除该数据
		deleteById(id);
		// 判断删除的数据是否为默认收货地址，如果是则需要修改最近修改过的为收货地址
		if (address.getIsDefault() == 1) {
			Integer count = getCountByUid(uid);
			// 判断该用户是否还有收货地址
			if (count > 0) {
				Address ar = findByLastModified(uid);
				Integer lastModifiedId = ar.getId();
				updateDefault(lastModifiedId, username, new Date());
			}
		}

	}

	@Override
	public Address getAddress(Integer id) {
	return findById(id);
	}

}
