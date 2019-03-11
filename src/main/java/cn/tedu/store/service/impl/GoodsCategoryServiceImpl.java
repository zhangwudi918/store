package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.service.IGoodsCategoryService;

@Service
public class GoodsCategoryServiceImpl implements IGoodsCategoryService {

	@Autowired
	private GoodsCategoryMapper goodsCategoryMapper;

	private List<GoodsCategory> findByParentId(Long parentId) {
		return goodsCategoryMapper.findByParentId(parentId);
	}

	@Override
	public List<GoodsCategory> getByParentId(Long parentId) {
		return findByParentId(parentId);
	}

}
