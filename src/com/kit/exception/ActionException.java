/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.exception;

/**
 * Class Description : This is a action exception class of current project,it
 * throws the exceptions of struts level
 * 
 * @version 1.0 Dec 02, 2008
 * @author Wu Guang Jing
 * 
 */
public class ActionException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionException() {
		super("ActionException");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ActionException(String code, String message, Throwable cause) {
		super(code, message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ActionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ActionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ActionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
