package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
	@Autowired
	private IUserService iUserService;

	@Test
	public void addnew() {
		try {

			User user = new User();
			user.setUsername("root");
			user.setPassword("1234");
			user.setGender(1);
			user.setPhone("12344212341");
			user.setEmail("awdw");
			User date = iUserService.reg(user);
			System.err.println(date);
		} catch (ServiceException e) {
			System.err.println(e.getMessage());
		}

	}

	@Test
	public void login() {
		try {
			User user = iUserService.login("root5", "1234");
			System.err.println(user);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changePassword() {
		try {
			iUserService.changePassword(5, "4321", "1234");
			System.err.println("修改完毕");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changeInfo() {
		try {
			User user = new User();
			user.setId(5);
			user.setUsername("root");
			user.setPassword("1234");
			user.setGender(0);
			user.setPhone("12332222222");
			user.setEmail("awdw");
			iUserService.changeInfo(user);
			System.err.println("修改完毕");

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changeAvatar() {
		try {
			iUserService.changeAvatar(3, "1111");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
