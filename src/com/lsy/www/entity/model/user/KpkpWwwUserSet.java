/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;

/**
 * Description:用户设置
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserSet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String ios;
	private String android;
	private String web;
	private String wechat;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIos() {
		return ios;
	}

	public void setIos(String ios) {
		this.ios = ios;
	}

	public String getAndroid() {
		return android;
	}

	public void setAndroid(String android) {
		this.android = android;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

}