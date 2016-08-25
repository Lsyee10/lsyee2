/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户邮件认证
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserAuthMail implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer mailId;
	private Integer userId;
	private String email;
	private String content;
	private String authCode;
	private Integer useFlag;
	private Timestamp sendTime;
	private Integer checkFlag;
	private Integer checkTimes;

	public Integer getMailId() {
		return mailId;
	}

	public void setMailId(Integer mailId) {
		this.mailId = mailId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public Integer getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(Integer useFlag) {
		this.useFlag = useFlag;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Integer getCheckTimes() {
		return checkTimes;
	}

	public void setCheckTimes(Integer checkTimes) {
		this.checkTimes = checkTimes;
	}

}