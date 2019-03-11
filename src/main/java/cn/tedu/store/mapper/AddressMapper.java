package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

public interface AddressMapper {

	/**
	 * 向数据库中插入用户地址数据
	 * 
	 * @param address
	 *            收货地址数据
	 * @return 受影响的行数
	 */
	Integer addnew(Address address);

	/**
	 * 通过用户id查询所有的用户地址数据的数量
	 * 
	 * @param uid
	 *            用户id
	 * @return 收货地址数量
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * 通过uid查找收货地址信息
	 * @param uid 
	 * @return 信息集合
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 通过用户id修改其所有收货地址的is_default值
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer updateNonDefault(@Param("uid")Integer uid,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 通过用户上传id修改其地址默认值
	 * @param id 地址id
	 * @return 受影响的行数
	 */
	Integer updateDefault(@Param("id")Integer id,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 通过id查找收货地址信息
	 * @param id 收货地址id
	 * @return 收货地址信息
	 */
	Address findById(Integer id);
	/**
	 * 通过地址id删除收货地址
	 * @param id
	 * @return
	 */
	Integer deleteById(Integer id);
	
	/**
	 * 通过用户id查找最近修改过的收货地址
	 * @param uid
	 * @return 返回收货地址信息，没有则返回null
	 */
	Address findByLastModified(Integer uid);
}
