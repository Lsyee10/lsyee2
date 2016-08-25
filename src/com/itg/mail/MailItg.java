/**
 * Project : xsee
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.itg.mail;

/**
 * Description:邮件发送业务接口
 * 
 * @version 1.0 2015年2月27日
 * @author Wu guang jing
 * 
 */
public interface MailItg {

	/**
	 * 发送邮件
	 * 
	 * @param stmp 
	 * @param username
	 * @param password
	 * @param auth
	 * @param from
	 * @param to
	 * @param subject
	 * @param content
	 * @return
	 */
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String subject, String content);

	/**
	 * 发送邮件，带抄送
	 * 
	 * @param stmp
	 * @param username
	 * @param password
	 * @param auth
	 * @param from
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @return
	 */
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String copyto, String subject, String content);

	/**
	 * 发送邮件，带抄送和附件
	 * 
	 * @param stmp
	 * @param username
	 * @param password
	 * @param auth
	 * @param from
	 * @param to
	 * @param copyto
	 * @param subject
	 * @param content
	 * @param attach
	 * @return
	 */
	public boolean send(String stmp, String username, String password, boolean auth, String from, String to,
			String copyto, String subject, String content, String attach);
}
