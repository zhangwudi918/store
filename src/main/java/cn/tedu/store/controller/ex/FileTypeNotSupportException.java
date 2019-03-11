package cn.tedu.store.controller.ex;

/**
 * 上传文件类型不支持异常
 * @author soft01
 *
 */
public class FileTypeNotSupportException extends FileUploadException {

	
	private static final long serialVersionUID = 633495072237254839L;

	public FileTypeNotSupportException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotSupportException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotSupportException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotSupportException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileTypeNotSupportException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
