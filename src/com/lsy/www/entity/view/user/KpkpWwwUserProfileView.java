/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;


/**
 * Description:用户资料视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwUserProfileView {

	private Integer userId;
	private String nickname;
	private String avatar;
	private String intro;
	private String bgImg;
	private Integer photos;
	private Integer focus;
	private Integer fans;
	private Integer stars;
	private Integer focusFlag;
	private String cellphone;
	private String email;
	private String city;
	private String newestImg;

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

	public String getBgImg() {
		return bgImg;
	}

	public void setBgImg(String bgImg) {
		this.bgImg = bgImg;
	}

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

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}

	public String getCellphone() {
//		return StringHelper.ifNull(cellphone) ? "未绑定" : cellphone;
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
//		return StringHelper.ifNull(email) ? "未绑定" : email;
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNewestImg() {
		return newestImg;
	}

	public void setNewestImg(String newestImg) {
		this.newestImg = newestImg;
	}

}
