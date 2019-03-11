package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.vo.OrderVO;

public interface OrderMapper {

	/**
	 * 向订单表中插入订单数据
	 * @param order
	 * @return
	 */
	Integer insert(Order order);
	
	/**
	 * 向订单详情表中插入订单详情
	 * @param orderItem
	 * @return
	 */
	Integer insertItem(OrderItem orderItem);
	
	/**
	 * 通过订单id查找详细订单属性
	 * @param id
	 * @return
	 */
	OrderVO findById(Integer id);
	
}
