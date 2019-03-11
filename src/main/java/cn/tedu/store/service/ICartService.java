package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

public interface ICartService {

	/**
	 * 添加数据到购物车中
	 * @param cart 商品数据
	 */
	void addToCart(Cart cart,String username)throws InsertException,UpdateException;
	
	/**
	 * 通过用户id查找其所属的购物车信息
	 * @param uid
	 * @return
	 */
	List<CartVO> findByUid(Integer uid);
	
	/**
	 * 根据购物车id修改该物品数量
	 * @param id
	 * @param uid
	 * @return
	 */
	void addCount(Integer id,Integer uid,String modifiedUser)throws CartNotFoundException,AccessDeniedException;
	
	/**
	 * 通过商品id查找商品信息，用来确认支付信息
	 * @param ids
	 * @return
	 */
	List<CartVO> findByIds(Integer[] ids);

}
