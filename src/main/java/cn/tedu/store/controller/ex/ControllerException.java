package cn.tedu.store.controller.ex;

/**
 * 上传文件异常的基类异常
 * @author soft01
 *
 */
public class ControllerException extends RuntimeException {

	private static final long serialVersionUID = 817656346289163665L;

	public ControllerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ControllerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
