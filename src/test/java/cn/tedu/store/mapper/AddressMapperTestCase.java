package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {
	@Autowired
	private AddressMapper addressMapper;

	@Test
	public void addnew() {
		Address address = new Address();
		address.setUid(4);
		Integer rows = addressMapper.addnew(address);
		System.err.println(rows);
	}
	
	@Test
	public void getCountByUid() {
		Integer rows = addressMapper.getCountByUid(4);
		System.err.println(rows);
	}
	
	@Test
	public void getAddressByUid() {
		List<Address> list= addressMapper.findByUid(5);
		System.err.println(list);
	}
	 
	@Test
	public void updataNonDefault() {
		Integer rows=addressMapper.updateNonDefault(5,"root",new Date());
		System.out.println(rows);
	}
	
	@Test
	public void updataDefault() {
		Integer rows=addressMapper.updateDefault(10,"root1",new Date());
		System.out.println(rows);
	}
	
	@Test
	public void delete() {
		Integer rows=addressMapper.deleteById(14);
		System.out.println(rows);
	}
}
