/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

/**
 * Description:用户注册表单
 * 
 * @version 1.0 2015年12月14日
 * @author Wu guang jing
 */
public class KpkpWwwUserRegisterForm {

	private String nickname;
	private String accept;
	private String password;
	private String cfmPassword;
	private String authCode;
	private String username;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCfmPassword() {
		return cfmPassword;
	}

	public void setCfmPassword(String cfmPassword) {
		this.cfmPassword = cfmPassword;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
