package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTestCase {

	@Autowired
	private CartMapper cartMapper;
	@Test
	public void addnew() {
		Cart cart=new Cart();
		Date now=new Date();
		cart.setCount(1);
		cart.setGid(234l);
		cart.setCreatedTime(now);
		cart.setUid(23);
		cart.setPrice(12l);
		Integer rows=cartMapper.addnew(cart);
		System.err.println(rows);
	}
	
	@Test
	public void findByUidAndGid() {
		System.out.println(cartMapper.findByUidAndGid(23, 234l));
	}

	@Test
	public void findByUid() {
	List<CartVO> list=cartMapper.findByUid(5);
	System.err.println(list);
	}
	
	@Test
	public void findById() {
		Integer[] arr=new Integer[] {9,10};
	List<CartVO> list=cartMapper.findByIds(arr);
	System.out.println(list);
	}
}
