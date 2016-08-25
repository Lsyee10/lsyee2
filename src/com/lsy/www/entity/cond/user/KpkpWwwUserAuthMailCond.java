/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.util.SystemConstant;
import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户邮件认证查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserAuthMailCond extends KpkpWwwBaseCond {

	private Integer mailId;
	private Integer userId;
	private Integer userIdNeq;
	private String email;
	private String authCode;
	private Integer useFlag;
	private Integer checkFlag;
	private String sendTimeSt;
	private String sendTimeEd;

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

	public Integer getUserIdNeq() {
		return userIdNeq;
	}

	public void setUserIdNeq(Integer userIdNeq) {
		this.userIdNeq = userIdNeq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}
	
	public String getSendTimeSt() {
		if ("".equals(this.sendTimeSt) || null == this.sendTimeSt) {
			return null;
		} else {
			return this.sendTimeSt + SystemConstant.QUERY_TIME_START;
		}
	}

	public void setSendTimeSt(String sendTimeSt) {
		this.sendTimeSt = sendTimeSt;
	}

	public String getSendTimeEd() {
		if ("".equals(this.sendTimeEd) || null == this.sendTimeEd) {
			return null;
		} else {
			return this.sendTimeEd + SystemConstant.QUERY_TIME_END;
		}
	}

	public void setSendTimeEd(String sendTimeEd) {

		this.sendTimeEd = sendTimeEd;
	}

}