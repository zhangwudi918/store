package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

public interface CartMapper {
	/**
	 * 通过用户id和商品id查找购物车数据
	 * 
	 * @param uid
	 *            用户id
	 * @param gid
	 *            商品id
	 * @return 购物车中数据信息
	 */
	Cart findByUidAndGid(@Param("uid") Integer uid, @Param("gid") Long gid);

	/**
	 * 根据id查找匹配数据，没有时则返回null
	 * @param id
	 * @return
	 */
	Cart findById(Integer id);
	
	/**
	 * 向购物车中添加新数据
	 * 
	 * @param cart
	 *            购物车数据
	 * @return
	 */
	Integer addnew(Cart cart);

	/**
	 * 修改指定id的购物车数据的数量
	 * 
	 * @param id
	 * @param count
	 * @return
	 */
	Integer updateCount(@Param("id") Integer id, @Param("count") Integer count,@Param("modifiedUser")String modifiedUser,@Param("modifiedTime")Date modifiedTime);

	
	
	
	/**
	 * 通过用户id查询其购物车所有信息
	 * @param uid
	 * @return
	 */
	List<CartVO> findByUid(Integer uid);
	
	/**
	 * 通过id数组查询对应购物车数据
	 * @param ids
	 * @return
	 */
	List<CartVO> findByIds(Integer[] ids);
}
