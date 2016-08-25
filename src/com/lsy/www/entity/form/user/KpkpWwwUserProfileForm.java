/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

import java.io.File;

/**
 * Description:用户资料表单
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwUserProfileForm {

	private Integer userId;
	private String nickname;
	private String intro;
	private String city;
	private String path;
	private File image;

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

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
}
