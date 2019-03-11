package cn.tedu.store.service;

import cn.tedu.store.entity.Order;
import cn.tedu.store.vo.OrderVO;

/**
 * 订单表service抽象类
 * @author soft01
 *
 */
public interface IOrderService {

	/**
	 * 创建订单数据
	 * @param uid 用户id
	 * @param addressId  收货地址id
	 * @param ids 购物车商品id
	 * @return
	 */
	Order createOrder(Integer uid,Integer addressId,String username,Integer[] ids);
	
	/**
	 * 通过订单id查找详细订单属性
	 * @param id 订单id
	 * @return
	 */
	OrderVO getById(Integer id);

}
