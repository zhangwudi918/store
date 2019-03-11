package cn.tedu.store.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的持久层
 * 
 * @author soft01
 *
 */
public interface UserMapper {
	/**
	 * 插入用户数据
	 * 
	 * @param user
	 *            用户数据
	 * @return 受影响的行数
	 */
	Integer addnew(User user);

	/**
	 * 根据用户名查询用户数据
	 * 
	 * @param username
	 *            用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null。
	 */
	User findByUsername(String username);

	/**
	 * 修改密码
	 * 
	 * @param password
	 *            新密码
	 * @param modifiedUser
	 *            修改人
	 * @param modifiedTime
	 *            修改时间
	 * @param id
	 *            用户id
	 * @return 受影响的行数
	 */
	Integer updatePassword(@Param("password") String password, @Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime, @Param("id") Integer id);

	/**
	 * 通过id查找用户
	 * 
	 * @param id
	 * @return 符合该id的用户数据 如果没有则返回null
	 */
	User findById(Integer id);

	/**
	 * 修改用户资料，不含密码和头像
	 * 
	 * @param user
	 * @return 受影响的行数
	 */
	Integer updateInfo(User user);

	/**
	 *  修改用户头像
	 * @param id 用户id
	 * @param avatar 头像保存路径
	 * @param modifiedUser 修改人
	 * @param modifiedTime 修改时间
	 * @return
	 */
	Integer updataAvatar(@Param("id") Integer id, @Param("avatar") String avatar,
			@Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);
}
