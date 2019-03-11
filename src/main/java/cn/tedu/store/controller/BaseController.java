package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.controller.ex.ControllerException;
import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileSizeOutOfLimitException;
import cn.tedu.store.controller.ex.FileTypeNotSupportException;
import cn.tedu.store.controller.ex.FileUploadException;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.AddressNotFoundException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.DuplicateionKeyException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.util.ResponseResult;

public abstract class BaseController {

	public static final Integer SUCCESS = 200;

	@ExceptionHandler({ ServiceException.class, ControllerException.class })
	@ResponseBody
	public ResponseResult<Void> handerException(Exception e) {
		if (e instanceof DuplicateionKeyException) {
			// 400-违反里Unique约束的异常
			return new ResponseResult<>(400, e);
		} else if (e instanceof UserNotFoundException) {
			// 401-用户数据不存在
			return new ResponseResult<>(401, e);
		} else if (e instanceof PasswordNotMatchException) {
			// 402-密码错误
			return new ResponseResult<>(402, e);
		} else if (e instanceof AddressNotFoundException) {
			// 700-收货地址不存在
			return new ResponseResult<>(403, e);
		} else if (e instanceof AccessDeniedException) {
			// 701-地址访问权限异常
			return new ResponseResult<>(404, e);
		} else if (e instanceof InsertException) {
			// 500-插入数据异常
			return new ResponseResult<>(500, e);
		} else if (e instanceof UpdateException) {
			// 501-修改数据异常
			return new ResponseResult<>(501, e);
		} else if (e instanceof DeleteException) {
			// 502-文件删除异常
			return new ResponseResult<>(502, e);
		}else if (e instanceof FileEmptyException) {
			// 600-上传文件为空
			return new ResponseResult<>(600, e);
		} else if (e instanceof FileSizeOutOfLimitException) {
			// 601-上传文件超出限制
			return new ResponseResult<>(601, e);
		} else if (e instanceof FileTypeNotSupportException) {
			// 602-上传文件类型不支持
			return new ResponseResult<>(602, e);
		} else if (e instanceof FileUploadException) {
			// 610-文件上传异常
			return new ResponseResult<>(610, e);
		}else if (e instanceof CartNotFoundException) {
			// 800-购物车数据不存在
			return new ResponseResult<>(800, e);
		}
		return null;

	}

	protected Integer getIdFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("id").toString());
	}
}
