/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;

/**
 * Description:用户关注视图
 * 
 * @version 1.0 2015年12月2日
 * @author Wu guang jing
 */
public class KpkpWwwUserFocusView {

	private Integer userId;// 等于shooterId
	private String nickname;
	private String avatar;
	private String addTimeDes;
	private Integer focusFlag;
	private String intro;
	private Integer photos;
	private Integer fans;
	private Integer focus;

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

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
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
