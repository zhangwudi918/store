package cn.tedu.store.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void addnew() {
		User user = new User();
		user.setUsername("root");
		user.setPassword("1234");
		user.setGender(1);
		user.setPhone("12344212341");	
		Integer rows = userMapper.addnew(user);
		System.out.println(rows);
	}

	@Test
	public void findByUsername() {
		User user = userMapper.findByUsername("root");
		System.err.println(user);
	}
	
	@Test
	public void findById() {
		User user = userMapper.findById(2);
		System.err.println(user);
	}
	
	@Test
	public void updataPassword() {
		Date data=new Date();
		Integer i=userMapper.updatePassword("1234", "张三", data, 2);
		System.err.println(i);
	}
	
	@Test
	public void updataInfo() {
		Date data=new Date();
		User user=new User();
		user.setGender(1);
		user.setPhone("13287666666");
		user.setEmail("qq.email");
		user.setModifiedUser("zhangsan");
		user.setModifiedTime(data);
		user.setId(3);
		Integer i=userMapper.updateInfo(user);
		System.err.println(i);
	}
	
	@Test
	public void updateAvatar() {
		Integer i=userMapper.updataAvatar(4, "str", "zhangsan", new Date());
		System.out.println(i);
	}
	
	

}
