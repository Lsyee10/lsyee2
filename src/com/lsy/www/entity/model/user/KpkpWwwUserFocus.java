/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户关注
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserFocus implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer focusId;
	private Integer userId;
	private Integer shooterId;
	private Timestamp focusTime;

	// 用户账号资料
	private String nickname;
	private String avatar;
	private String intro;

	// 用户统计数据
	private Integer photos;
	private Integer fans;
	private Integer focus;

	public Integer getFocusId() {
		return focusId;
	}

	public void setFocusId(Integer focusId) {
		this.focusId = focusId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getShooterId() {
		return shooterId;
	}

	public void setShooterId(Integer shooterId) {
		this.shooterId = shooterId;
	}

	public Timestamp getFocusTime() {
		return focusTime;
	}

	public void setFocusTime(Timestamp focusTime) {
		this.focusTime = focusTime;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

	public Integer getFocus() {
		return focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

}