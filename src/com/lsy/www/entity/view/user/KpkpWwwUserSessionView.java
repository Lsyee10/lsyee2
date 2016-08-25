/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;

import java.io.Serializable;

/**
 * Description:用户账号视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwUserSessionView implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String nickname;
	private String cellphone;
	private String email;
	private String avatar;
	private Integer typeFlag;
	private String webSessionId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(Integer typeFlag) {
		this.typeFlag = typeFlag;
	}

	public String getWebSessionId() {
		return webSessionId;
	}

	public void setWebSessionId(String webSessionId) {
		this.webSessionId = webSessionId;
	}
}
