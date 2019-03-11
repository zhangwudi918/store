package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Goods;
/**
 * 商品数据的持久层接口
 * @author soft01
 *
 */
public interface GoodsMapper {

	/**
	 * 通过分类id查找该分类下所有商品信息
	 * @param categoryId 分类id
	 * @param offset 偏移量
	 * @param count 获取数据的最大数量
	 * @return 该分类下所有商品信息
	 */
	List<Goods> findByCategoryId(@Param("categoryId")Long categoryId,@Param("offset")Integer offset,@Param("count")Integer count);
	
	/**
	 * 通过商品id找到该商品信息
	 * @param id 商品id
	 * @return 商品信息
	 */
	Goods findById(Long id);
	
	/**
	 * 根据优先级查询前几条数据
	 * @param count 查询数据量
	 * @return
	 */
	List<Goods> findByPriority(Integer count);
	
}
