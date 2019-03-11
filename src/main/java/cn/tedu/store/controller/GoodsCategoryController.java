package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/category")
public class GoodsCategoryController extends BaseController {

	@Autowired
	private IGoodsCategoryService goodsCategoryService;
	/**
	 * 通过父类id查找指定父级分类下的所有子级分类的数据
	 * @param parentId 父类id
	 * @return 所有子级分类的数据
	 */
	@RequestMapping("/list/{parentId}")
	public ResponseResult<List<GoodsCategory>> getByParentId(@PathVariable("parentId") Long parentId) {
		List<GoodsCategory> list = goodsCategoryService.getByParentId(parentId);
		return new ResponseResult<List<GoodsCategory>>(SUCCESS, list);
	}
}
