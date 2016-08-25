/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户账号
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String nickname;
	private String avatar;
	private String intro;
	private String password;
	private String cellphone;
	private String email;
	private String qq;
	private String wechat;
	private String weibo;
	private String province;
	private String city;
	private String appBgImg;
	private String webBgImg;
	private String appTokenId;
	private String webSessionId;
	private String wechatOpenId;
	private Integer topFlag;
	private Integer typeFlag;
	private Integer stateFlag;
	private Integer loginFlag;
	private Integer recycleFlag;
	private Timestamp regTime;
	private Timestamp topTime;
	private Timestamp loginTime;
	private String loginIp;

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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
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

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getAppTokenId() {
		return appTokenId;
	}

	public void setAppTokenId(String appTokenId) {
		this.appTokenId = appTokenId;
	}

	public String getWebSessionId() {
		return webSessionId;
	}

	public void setWebSessionId(String webSessionId) {
		this.webSessionId = webSessionId;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getTypeFlag() {
		return typeFlag;
	}

	public void setTypeFlag(Integer typeFlag) {
		this.typeFlag = typeFlag;
	}

	public Integer getStateFlag() {
		return stateFlag;
	}

	public void setStateFlag(Integer stateFlag) {
		this.stateFlag = stateFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public String getAppBgImg() {
		return appBgImg;
	}

	public void setAppBgImg(String appBgImg) {
		this.appBgImg = appBgImg;
	}

	public String getWebBgImg() {
		return webBgImg;
	}

	public void setWebBgImg(String webBgImg) {
		this.webBgImg = webBgImg;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Timestamp getTopTime() {
		return topTime;
	}

	public void setTopTime(Timestamp topTime) {
		this.topTime = topTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Integer getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}
}
