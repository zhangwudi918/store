package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Goods;
/**
 * 商品数据的业务层接口
 * @author soft01
 *
 */
public interface IGoodsService {

	/**
	 * 根据分类id找到该分类下所有商品信息
	 * @param categoryId 分类id
	 * @param offset 偏移值
	 * @param count 返回商品数据数量
	 * @return 所有信息的集合，若没有数据。返回一个长度为0的集合
	 */
	List<Goods> getByCategoryId(Long categoryId,Integer offset,Integer count);
	

	/**
	 * 通过商品id找到该商品信息
	 * @param id 商品id
	 * @return 商品信息
	 */
	Goods getById(Long id);
	
	/**
	 * 根据优先级查询前几条数据
	 * @param count 查询数据量
	 * @return
	 */
	List<Goods> getByPriority(Integer count);


}
