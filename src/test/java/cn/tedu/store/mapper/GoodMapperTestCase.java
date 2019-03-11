package cn.tedu.store.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Goods;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodMapperTestCase {
	@Autowired
	private GoodsMapper goodsMapper;

	@Test
	public void findByCategoryId() {
		List<Goods> list = goodsMapper.findByCategoryId((long) 238, 0, 10);
		System.out.println(list);
	}
	
	@Test
	public void findByPriority() {
		List<Goods> list = goodsMapper.findByPriority(4);
		System.out.println(list);
	}
}
