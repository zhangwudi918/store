package cn.tedu.store.service;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.DuplicateionKeyException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;

public interface IUserService {
	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户的注册信息
	 * @return 成功注册的用户信息
	 * @throws DuplicateionKeyException
	 * @throws InsertException
	 */
	User reg(User user) throws DuplicateionKeyException, InsertException;

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户输入的用户名
	 * @param password
	 *            用户输入的用户密码
	 * @return 用户信息
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 */
	User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;

	/**
	 * 修改密码
	 * 
	 * @param id
	 *            用户id
	 * @param oldPassword
	 *            原密码
	 * @param newPassword
	 *            新密码
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 * @throws UpdateException
	 */
	void changePassword(Integer id, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException;

	/**
	 * 修改用户数据
	 * 
	 * @param user
	 *            新的用户数据
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeInfo(User user) throws UserNotFoundException, UpdateException;

	/**
	 * 根据id获取用户数据
	 * 
	 * @param id
	 * @return
	 */
	User getById(Integer id);

	/**
	 * 修改用户数据
	 * @param id 用户id
	 * @param avatar 图片路径
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeAvatar(Integer id, String avatar) throws UserNotFoundException, UpdateException;;
}
