/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.logger;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;


/**
 * Class Description : SystemLog extends all members from Log4JLogger,and add
 * two methods that save logs into database and get logs from database
 * 
 * @version 1.0 2008/12/02
 * @author wgjwell
 * 
 */
public class SystemLog extends Log4JLogger {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SystemLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SystemLog(Logger arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public SystemLog(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// get SystemLog object
		SystemLog log = (SystemLog) LogFactory.getLog(SystemLog.class);

		log.fatal("FATAL");// fatal message log
		log.error("Error");// error message log
		log.warn("WARN");// warn message log
		log.info("INFO");// system message log
		log.debug("DEBUG");// debug message log

		Throwable mythrow = new Throwable("Test exception throws");
		log.error("Error", mythrow);// error message with throwable log
	}

}
