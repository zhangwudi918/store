package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.DuplicateionKeyException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User reg(User user) throws DuplicateionKeyException, InsertException {

		// 通过用户名查找用户信息
		User data = findByUsername(user.getUsername());
		// 如果返回值信息为空，用户名不存在，允许注册
		if (data == null) {
			Date now = new Date();
			// 通过摘要算法加密操作
			String salt = UUID.randomUUID().toString().toUpperCase();
			String srcPassword = user.getPassword();
			String md5Password = getMd5Password(srcPassword, salt).toUpperCase();
			user.setPassword(md5Password);
			user.setSalt(salt);
			// 补充数据，该数据不需要用户输入
			user.setIsDelete(0);
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(now);
			addnew(user);
			return user;
		} else {
			// 不为空表示已被占用，抛DuplicateionKeyException异常
			throw new DuplicateionKeyException("注册失败，用户名已存在");
		}

	}

	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根据用户名查询数据
		User user = findByUsername(username);
		// 判断查询结果是否为null
		if (user == null) {
			throw new UserNotFoundException("登录失败，用户名不存在");
		}
		// 获取盐值，然后对用户输入的密码做摘要运算，判断密码是否正确
		String salt = user.getSalt();
		String md5Password = getMd5Password(password, salt).toUpperCase();

		if (md5Password.equals(user.getPassword())) {
			// 判断该用户数据是否已经被删除
			if (user.getIsDelete() == 1) {
				throw new UserNotFoundException("登录失败，用户已被删除");
			}
			user.setSalt(null);
			user.setPassword(null);
			return user;

		} else {
			throw new PasswordNotMatchException("登录失败，密码错误");
		}
	}

	@Override
	public void changePassword(Integer id, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {
		// 根据id查询用户数据
		User user = findById(id);
		// 如果数据为空表示该用户数据不存在
		if (user == null) {
			throw new UserNotFoundException("该用户数据不存在");
		}
		if (user.getIsDelete() == 1) {
			throw new UserNotFoundException("该数据已经被删除");
		}
		// 将用户输入密码与查询到的盐值处理后结果与查询到的密码对比，结果不同则抛出密码错误异常
		String oldMd5pas = getMd5Password(oldPassword, user.getSalt()).toUpperCase();
		if (oldMd5pas.equals(user.getPassword())) {
			// 修改密码，将密码做摘要运算后存入数据库
			Date now = new Date();
			String newMd5pad = getMd5Password(newPassword, user.getSalt()).toUpperCase();
			updatePassword(newMd5pad, user.getUsername(), now, id);
		} else {
			throw new PasswordNotMatchException("原密码不正确！");
		}

	}

	@Override
	public void changeInfo(User user) throws UserNotFoundException, UpdateException {
		User data = findById(user.getId());
		if (data == null) {
			throw new UserNotFoundException("当前用户数据不存在");
		}
		if (data.getIsDelete() == 1) {
			throw new UserNotFoundException("用户数据已经删除");
		}
		user.setModifiedUser(data.getUsername());
		user.setModifiedTime(new Date());
		updateInfo(user);

	}

	@Override
	public User getById(Integer id) {
		User user = findById(id);
		user.setPassword(null);
		user.setSalt(null);
		user.setIsDelete(null);
		return user;
	}

	@Override
	public void changeAvatar(Integer id, String avatar) throws UserNotFoundException, UpdateException {
		User user = findById(id);
		if (user == null) {
			throw new UserNotFoundException("用户数据不存在");
		}
		if (user.getIsDelete() == 1) {
			throw new UserNotFoundException("用户数据已删除");
		}
		updateAvatar(id, avatar, user.getUsername(), new Date());

	}

	/**
	 * 插入用户数据
	 * 
	 * @param user
	 *            用户数据
	 * @throws InsertException
	 */
	private void addnew(User user) throws InsertException {
		Integer rows = userMapper.addnew(user);
		if (rows != 1) {
			throw new InsertException("增加用户数据时出现未知错误");
		}
	}

	/**
	 * 通过用户名查找用户信息
	 * 
	 * @param username
	 * @return
	 */
	private User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}

	/**
	 * 通过id查找用户数据
	 * 
	 * @param id
	 * @return
	 */
	private User findById(Integer id) {
		return userMapper.findById(id);
	}

	/**
	 * 通过id修改密码
	 * 
	 * @param password
	 * @param modifiedUser
	 * @param modifiedTime
	 * @param id
	 */
	private void updatePassword(String password, String modifiedUser, Date modifiedTime, Integer id) {
		Integer rows = userMapper.updatePassword(password, modifiedUser, modifiedTime, id);
		if (rows != 1) {
			throw new UpdateException("更新密码出现未知错误！");
		}
	}

	/**
	 * 更新个人资料
	 * 
	 * @param user
	 */
	private void updateInfo(User user) {
		Integer rows = userMapper.updateInfo(user);
		if (rows != 1) {
			throw new UpdateException("修改数据时出现未知异常");
		}

	}

	/**
	 * 修改用户头像
	 * 
	 * @param id
	 *            用户id
	 * @param avatar
	 *            图片存储路径
	 * @param modifiedUser
	 * @param modifiedTime
	 */
	private void updateAvatar(Integer id, String avatar, String modifiedUser, Date modifiedTime) {
		Integer rows = userMapper.updataAvatar(id, avatar, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("修改头像时出现未知异常");

		}
	}

	/**
	 * 密码加密方法
	 * 
	 * @param srcPassword
	 *            原密码
	 * @param salt
	 *            盐值
	 * @return 加密后密码
	 */
	private String getMd5Password(String srcPassword, String salt) {
		String str = salt + srcPassword + salt;
		for (int i = 0; i < 10; i++) {
			str = DigestUtils.md5DigestAsHex(str.getBytes());
		}
		return str;
	}

}
