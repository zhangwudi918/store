package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTestCase {
	@Autowired
	private IAddressService iAddressService;
	
	@Test
	public void create() {
		Address address=new Address();
		address.setUid(1);
		Address add=iAddressService.create(address, "zhangsan");
		System.out.println(add);
	}
	
	@Test
	public void findByUid() {
		List<Address> list=iAddressService.getListByUid(5);
		System.err.println(list);
	}
	
	@Test
	public void setDefault() {
		try {
			iAddressService.setDefault(9,5,"zhangsan");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
