package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.controller.ex.FileEmptyException;
import cn.tedu.store.controller.ex.FileSizeOutOfLimitException;
import cn.tedu.store.controller.ex.FileTypeNotSupportException;
import cn.tedu.store.controller.ex.FileUploadException;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	private static final String UPLOAD_DIR_NAME = "upload";
	private static final long FILE_MAX_SIZE = 5 * 1024 * 1024;
	private static final List<String> FILE_CONTENT_TYPES = new ArrayList<String>();
	static {
		FILE_CONTENT_TYPES.add("image/jpeg");
		FILE_CONTENT_TYPES.add("image/png");
	}
	@Autowired
	private IUserService userService;

	@PostMapping("/reg.do")
	public ResponseResult<Void> handleReg(User user) {
		userService.reg(user);
		return new ResponseResult<Void>(SUCCESS);
	}

	@PostMapping("/login.do")
	public ResponseResult<User> handleLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		User user = userService.login(username, password);
		session.setAttribute("id", user.getId());
		session.setAttribute("username", user.getUsername());
		return new ResponseResult<User>(SUCCESS,user);
	}

	@PostMapping("/password.do")
	public ResponseResult<Void> ChangePassword(@RequestParam("old_password") String oldPassword,
			@RequestParam("new_password") String newPassword, HttpSession session) {
		Integer id = getIdFromSession(session);
		userService.changePassword(id, oldPassword, newPassword);
		return new ResponseResult<Void>(SUCCESS);
	}

	@PostMapping("/change_info.do")
	public ResponseResult<Void> changeInfo(User user, HttpSession session) {
		// 获取当前登录的用户id，当前user是客户端用户输入的数据，不包含id
		Integer id = getIdFromSession(session);
		user.setId(id);
		userService.changeInfo(user);
		return new ResponseResult<Void>(SUCCESS);
	}

	@RequestMapping("/info.do")
	public ResponseResult<User> GetInfo(HttpSession session) {
		Integer id = getIdFromSession(session);
		User user = userService.getById(id);
		return new ResponseResult<User>(SUCCESS, user);
	}

	@PostMapping("/upload.do")
	public ResponseResult<String> chengeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {

		if (file.isEmpty()) {
			throw new FileEmptyException("上传文件为空");
		}
		if (file.getSize() > FILE_MAX_SIZE) {
			throw new FileSizeOutOfLimitException("上传文件过大");
		}
		if (!FILE_CONTENT_TYPES.contains(file.getContentType())) {
			throw new FileTypeNotSupportException("文件类型不匹配");
		}
		// 创建上传文件夹
		String parentPath = session.getServletContext().getRealPath(UPLOAD_DIR_NAME);
		File parent = new File(parentPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		// 获取上传的原文件名
		String originalFileName = file.getOriginalFilename();
		// 截取文件名后缀
		String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
		// 新文件名
		String fileName = System.currentTimeMillis() + "" + (new Random().nextInt(1000000) + 100000) + suffix;
		// 创建上传文件对象
		File dest = new File(parent, fileName);

		try {
			file.transferTo(dest);
			System.err.println("上传完成！");
		} catch (IllegalStateException e) {
			throw new FileUploadException("上传失败，稍后重试");
		} catch (IOException e) {
			throw new FileUploadException("上传失败，稍后重试");
		}
		
		Integer id = getIdFromSession(session);
		String avatar = "/" + UPLOAD_DIR_NAME + "/" + fileName;
		//将数据传入数据库
		userService.changeAvatar(id, avatar);
		ResponseResult<String> rr = new ResponseResult<String>(SUCCESS);
		//向客户端页面返回图片地址
		rr.setData(avatar);
		return rr;
	}
}
