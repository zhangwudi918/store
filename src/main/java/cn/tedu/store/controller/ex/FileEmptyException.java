package cn.tedu.store.controller.ex;

/**
 * 上传文件为空异常
 * @author soft01
 *
 */
public class FileEmptyException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1241017634099485103L;

	public FileEmptyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileEmptyException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileEmptyException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileEmptyException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
