package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartMapper cartMapper;

	private List<CartVO> getByIds(Integer[] ids) {
		return cartMapper.findByIds(ids);
	}

	private Cart findById(Integer id) {
		return cartMapper.findById(id);
	}

	private List<CartVO> getByUid(Integer uid) {
		return cartMapper.findByUid(uid);
	}

	private Cart findByUidAndGid(Integer uid, Long gid) {
		return cartMapper.findByUidAndGid(uid, gid);
	}

	private void addnew(Cart cart) {
		Integer rows = cartMapper.addnew(cart);
		if (rows != 1) {
			throw new InsertException("加入购物车失败，数据插入异常");
		}
	}

	private void updateCount(Integer id, Integer count, String modifiedUser, Date modifiedTime) {
		Integer rows = cartMapper.updateCount(id, count, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("加入购物车失败，数据修改异常");
		}
	}

	@Override
	public void addToCart(Cart cart, String username) {
		Cart inCart = findByUidAndGid(cart.getUid(), cart.getGid());
		Date now = new Date();
		if (inCart == null) {
			cart.setCreatedTime(now);
			addnew(cart);
		} else {
			Integer count = inCart.getCount() + cart.getCount();
			updateCount(inCart.getId(), count, username, now);
		}
	}

	@Override
	public List<CartVO> findByUid(Integer uid) {
		return getByUid(uid);
	}

	@Override
	public void addCount(Integer id, Integer uid, String modifiedUser)
			throws CartNotFoundException, AccessDeniedException {
		Cart cart = findById(id);
		if (cart == null) {
			throw new CartNotFoundException("修改商品数量失败，未找到该数据");
		}
		if (uid != cart.getUid()) {
			throw new AccessDeniedException("修改商品数量失败，访问数据权限验证失败");
		}
		Integer count = cart.getCount() + 1;
		updateCount(id, count, modifiedUser, new Date());
	}

	@Override
	public List<CartVO> findByIds(Integer[] ids) {

		return getByIds(ids);
	}

}
