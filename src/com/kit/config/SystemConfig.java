/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.kit.config;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class Description : SystemConfig is used to get properties from property files
 * 
 * @version 1.0 2008-12-2
 * @author Wu Guang Jing
 * 
 */
public class SystemConfig {
	private static Properties properties = null;

	/**
	 * Load properties from property file
	 */
	private static void loadProperties(String relativePath) {
		properties = new Properties();
		try {
			InputStream input = SystemConfig.class
					.getResourceAsStream(relativePath);
			properties.load(input);
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	/**
	 * get property values
	 * 
	 * @param propertyName
	 * @param relativePath
	 *            example as : "/sysConfig.properties"
	 * @return
	 */
	public static String getProperty(String propertyName, String relativePath) {
		if (!"".equals(relativePath)) {
			loadProperties(relativePath);
		} else {
			loadProperties("/sysConfig.properties");
		}
		return properties.getProperty(propertyName);
	}
}
