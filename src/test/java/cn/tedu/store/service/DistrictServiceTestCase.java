package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTestCase {
	@Autowired
	private IDistrictService districtService;

	@Test
	public void findByCode() {
		District district = districtService.getByCode(null);
		System.out.println(district);
	}

	@Test
	public void findByParent() {
		List<District> list = districtService.getListByParent("86");
		System.err.println("Start");
		for (District d : list) {
			System.err.println(d);
		}
		System.err.println("end");

	}

}
