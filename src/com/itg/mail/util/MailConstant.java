/**
 * Project : xsee
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.itg.mail.util;

import com.kit.config.SystemConfig;

/**
 * Description:邮件集成静态常量
 * 
 * @version 1.0 2015年7月3日
 * @author Wu guang jing
 * 
 */
public class MailConstant {

	// 邮件配置
	public final static String MAIL_SMTP_HOST = SystemConfig.getProperty("mail_smtp_host", "/sysConfig.properties");
	public final static String MAIL_SEND_USERNAME = SystemConfig.getProperty("mail_send_username",
			"/sysConfig.properties");
	public final static String MAIL_SEND_PASSWORD = SystemConfig.getProperty("mail_send_password",
			"/sysConfig.properties");
}
