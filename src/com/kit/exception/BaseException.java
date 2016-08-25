/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.exception;

/**
 * Class Description:This is a basic exception class of current project,it
 * extends from Exception,and extended by other exception class
 * 
 * @version 1.0 2007/12/10
 * @author Wu Guang Jing
 * 
 */
public class BaseException extends Exception {

	/**
	 * serialVersionUID = 1L
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * the code of error message
	 */
	protected String errorCode; // error code

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * constructor with no parameter
	 */
	public BaseException() {
		super("BaseException");
	}

	/**
	 * @param message
	 */
	public BaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseException(String code, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = code;
	}
}
