package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

/**
 * 购物车数据控制器类
 * 
 * @author soft01
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController extends BaseController {
	@Autowired
	private ICartService cartService;

	@PostMapping("/add_to_cart")
	public ResponseResult<Void> addToCart(Cart cart, HttpSession session) {
		String username = session.getAttribute("username").toString();
		cart.setCreatedUser(username);
		Integer uid = getIdFromSession(session);
		cart.setUid(uid);
		cartService.addToCart(cart, username);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/list")
	public ResponseResult<List<CartVO>> findByUid(HttpSession session) {
		Integer uid = getIdFromSession(session);
		List<CartVO> list = cartService.findByUid(uid);
		return new ResponseResult<List<CartVO>>(SUCCESS, list);
	}

	@RequestMapping("/add")
	public ResponseResult<Void> addCount(@RequestParam("id") Integer id, HttpSession session) {
		Integer uid = getIdFromSession(session);
		String modifiedUser = session.getAttribute("username").toString();
		cartService.addCount(id, uid, modifiedUser);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("findByIds")
	public ResponseResult<List<CartVO>> findByIds(Integer[] id) {
		List<CartVO> list = cartService.findByIds(id);
		return new ResponseResult<List<CartVO>>(SUCCESS, list);
	}

}
