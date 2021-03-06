/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.exception;

/**
 * Class Description:This is a service exception class of current project,it
 * throws the exceptions of service level
 * 
 * @version 1.0 2008/12/02
 * @author Wu Guang Jing
 * 
 */
public class ServiceException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor with no parameter
	 */
	public ServiceException() {
		super("ServiceException");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ServiceException(String code, String message, Throwable cause) {
		super(code, message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
