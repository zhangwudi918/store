package cn.tedu.store.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.vo.OrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	public void insert() {
		Order order=new Order();
		
	Integer rows=	orderMapper.insert(order);
	System.out.println(rows);
	}

	@Test
	public void insertItem() {
		OrderItem order=new OrderItem();
		
	Integer rows=	orderMapper.insertItem(order);
	System.out.println(rows);
	}
	
	@Test
	public void select() {
		
	OrderVO o=orderMapper.findById(5);
	System.out.println(o);
	}
	
}
