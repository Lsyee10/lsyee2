/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:用户联系方式绑定
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwUserContactForm extends KpkpWwwBaseForm{

	private String accept;
	private String authCode;
	private String cellphone;
	private String email;

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
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

}
