package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IGoodsService;
@Service
public class GoodsServiceImpl implements IGoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	private List<Goods> findByPriority(Integer count){
		return goodsMapper.findByPriority(count);
	}
	
	private List<Goods> findByCategoryId(Long categoryId,Integer offset,Integer count){
		return goodsMapper.findByCategoryId(categoryId,offset,count);
	}
	
	private Goods findById(Long id) {
		return goodsMapper.findById(id);
	}
	@Override
	public List<Goods> getByCategoryId(Long categoryId,Integer offset,Integer count) {
		return findByCategoryId(categoryId,offset,count);
	}

	@Override
	public Goods getById(Long id) {
		return findById(id);
	}

	@Override
	public List<Goods> getByPriority(Integer count) {
		return findByPriority(count);
	}


}
