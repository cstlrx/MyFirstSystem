package io.lrx.user.service;

/**
 * @author lrx
 * @time 2016-11-3下午7:34:30
 */
/*
 * 自定义异常类只是给出父类构造器即可
 */
public class UserException extends Exception {

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
