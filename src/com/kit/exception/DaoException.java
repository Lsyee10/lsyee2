/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.exception;

/**
 * Class Description:This is a DAO exception class of current project,it throws
 * the exceptions of DAO level
 * 
 * @version 1.0 2008/12/02
 * @author Wu Guang Jing
 * 
 */
public class DaoException extends BaseException {

	private static final long serialVersionUID = 1L;

	/**
	 * constructor with no parameter
	 */
	public DaoException() {
		super("DaoException");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param message
	 * @param cause
	 */
	public DaoException(String code, String message, Throwable cause) {
		super(code, message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
