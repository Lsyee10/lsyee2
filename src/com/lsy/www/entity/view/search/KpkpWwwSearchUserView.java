/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.search;


/**
 * Description:搜索用户视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwSearchUserView {

	private Integer userId;
	private String nickname;
	private String avatar;
	private String intro;
	private Integer photos;
	private Integer focus;
	private Integer fans;
	private Integer focusFlag;

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getFocus() {
		return focus;
	}

	public void setFocus(Integer focus) {
		this.focus = focus;
	}

	public Integer getFans() {
		return fans;
	}

	public void setFans(Integer fans) {
		this.fans = fans;
	}

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

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}
}
