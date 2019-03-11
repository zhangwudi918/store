package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;

public interface IAddressService {

	/**
	 * 创建新收货地址
	 * @param address 收货地址数据
	 * @return 收货地址数据
	 * @throws InsertException
	 */
	Address create(Address address,String username)throws InsertException;
	
	/**
	 * 根据uid获得用户收货地址
	 * @param uid 
	 * @return 用户收货地址
	 */
	List<Address> getListByUid(Integer uid);
	
	/**
	 * 修改默认收货地址
	 * @param id 收货地址id
	 * @param uid 用户id
	 * @param username 修改人信息
	 */
	void setDefault(Integer id,Integer uid,String username);

	/**
	 * 通过id删除收货地址，并将最近修改的收货地址设为默认
	 * @param id 收货地址id
	 * @param uid 用户id
	 * @param usernmae 修改人信息
	 * @throws DeleteException
	 */
	void delete(Integer id,Integer uid,String username)throws DeleteException;
	
	/**
	 * 通过id查找表中收货地址
	 * @param id
	 * @return
	 */
	Address getAddress(Integer id);
}
