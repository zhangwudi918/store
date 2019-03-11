package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {
	@Autowired
	private IOrderService orderService;

	@Test
	public void find() {
		Order order = orderService.createOrder(5, 22, "zhangsan", new Integer[] { 9, 10 });
		System.out.println(order);
	}

}
