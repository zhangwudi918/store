package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.IOrderService;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.vo.CartVO;
import cn.tedu.store.vo.OrderVO;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ICartService cartService;
	@Autowired
	private IAddressService addressService;

	private 	OrderVO findById(Integer id) {
		
		return orderMapper.findById(id);
	}

	
	private void insert(Order order) {
		Integer rows = orderMapper.insert(order);
		if (rows != 1) {
			throw new InsertException("订单创建失败！数据插入异常");
		}
	}

	private void insertItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertItem(orderItem);
		if (rows != 1) {
			throw new InsertException("订单创建失败！数据插入异常");
		}
	}

	@Override
	@Transactional//开启事务
	public Order createOrder(Integer uid, Integer addressId, String username, Integer[] ids) {
		
		Long pay = 0l;
		//通过商品id查找对应的购物车商品信息
		List<CartVO> list = cartService.findByIds(ids);
		//遍历集合获取总价
		for (CartVO cartVO : list) {
			pay+= cartVO.getNewPrice() * cartVO.getCount();
		}
		Order order = new Order();
		Date now = new Date();
		order.setCreatedTime(now);
		order.setUid(uid);
		order.setPay(pay);
		order.setStatus(0);
		//获取地址信息
		Address address = addressService.getAddress(addressId);
		if(address==null) {
			throw new AddressNotFoundException("创建订单失败，收货地址未找到");
		}
		order.setRecvName(address.getName());
		order.setRecvDistrict(address.getDistrict());
		order.setRecvPhone(address.getPhone());
		order.setRecvAddress(address.getAddress());
		order.setCreatedUser(username);
		order.setOrderTime(now);
		//将订单信息插入订单表
		insert(order);
		//遍历购物车商品信息，将详细信息插入订单商品表中
		for (CartVO cartVO : list) {
			OrderItem oItem = new OrderItem();
			oItem.setOid(order.getId());
			oItem.setGoodsId(cartVO.getGid());
			oItem.setGoodsImage(cartVO.getImage());
			oItem.setGoodsPrice(cartVO.getNewPrice());
			oItem.setGoodsTitle(cartVO.getTitle());
			oItem.setGoodsCount(cartVO.getCount());
			oItem.setCreatedUser(username);
			oItem.setCreatedTime(now);
			insertItem(oItem);
		}

		return order;
	}


	@Override
	public OrderVO getById(Integer id) {
				return findById(id);
	}

}
