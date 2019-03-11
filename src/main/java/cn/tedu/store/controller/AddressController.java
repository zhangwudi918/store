package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.IAddressService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {

	@Autowired
	private IAddressService addressService;

	/*
	 * 写控制器需要考虑以下五点： 1.请求路径 2.请求类型 3.请求参数 4.响应数据 5.是否拦截
	 */
	@PostMapping("/create")
	public ResponseResult<Void> handleCreate(Address address, HttpSession session) {
		Integer uid = getIdFromSession(session);
		address.setUid(uid);
		String username = session.getAttribute("username").toString();
		addressService.create(address, username);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/list")
	public ResponseResult<List<Address>> getListByUid(HttpSession session) {
		Integer uid = getIdFromSession(session);
		List<Address> list = addressService.getListByUid(uid);
		return new ResponseResult<List<Address>>(SUCCESS, list);

	}
	
	@RequestMapping("/default/{id}")
	public ResponseResult<Void> setDefault(@PathVariable("id")Integer id,HttpSession session) {
		Integer uid=getIdFromSession(session);
		addressService.setDefault(id, uid,session.getAttribute("username").toString());
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@RequestMapping("/delete/{id}")
	public ResponseResult<Void> delete(@PathVariable("id")Integer id,HttpSession session){
		String username=session.getAttribute("username").toString();
		Integer uid=getIdFromSession(session);
		addressService.delete(id, uid, username);
		return new ResponseResult<Void>(SUCCESS);
	}
	
}
