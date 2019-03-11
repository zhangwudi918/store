package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Goods;
import cn.tedu.store.service.IGoodsService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	@Autowired
	private IGoodsService goodsService;

	@RequestMapping("/list/{categoryId}")
	public ResponseResult<List<Goods>> getByCategoryId(@PathVariable("categoryId") Long categoryId) {
		List<Goods> list = goodsService.getByCategoryId(categoryId,0,20);
		return new ResponseResult<List<Goods>>(SUCCESS, list);
	}
	
	@RequestMapping("/details/{id}")
	public ResponseResult<Goods> getById(@PathVariable("id") Long id) {
		Goods goods=goodsService.getById(id);
		return new ResponseResult<Goods>(SUCCESS, goods);
	}
	
	@RequestMapping("/hot")
	public ResponseResult<List<Goods>> getHotGoots() {
		List<Goods> list = goodsService.getByPriority(4);
		return new ResponseResult<List<Goods>>(SUCCESS, list);
	}
}
