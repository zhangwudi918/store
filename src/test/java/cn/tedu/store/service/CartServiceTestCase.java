package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTestCase {

	@Autowired
	private ICartService cartService;
	@Test
	public void addToCart() {
		Cart cart=new Cart();
		cart.setCount(1);
		cart.setGid(234l);
		cart.setUid(2);
		cart.setPrice(12l);
		cartService.addToCart(cart,"zhangsan");
	}
}
