/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:用户进出表单
 * 
 * @version 1.0 2015年12月14日
 * @author Wu guang jing
 */
public class KpkpWwwUserLoginForm extends KpkpWwwBaseForm{

	private String username;
	private String password;
	private String authCode;
	private String url;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
