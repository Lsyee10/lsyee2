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
public class ItgException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItgException() {
		super("ActionException");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param message
	 * @param cause
	 */
	public ItgException(String code, String message, Throwable cause) {
		super(code, message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ItgException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ItgException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ItgException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
