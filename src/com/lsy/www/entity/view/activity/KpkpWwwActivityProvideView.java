/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

/**
 * Description:活动投稿视图
 * 
 * @version 1.0 2015年12月22日
 * @author Li shi yuan
 */
public class KpkpWwwActivityProvideView {

	private Integer provideId;
	private Integer activityId;
	private Integer userId;
	private String nickname;
	private String avatar;
	private String addTimeDes;
	private String intro;
	private Integer topics;
	private Integer focus;
	private Integer fans;
	private Integer focusFlag;

	public Integer getProvideId() {
		return provideId;
	}

	public void setProvideId(Integer provideId) {
		this.provideId = provideId;
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

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getTopics() {
		return topics;
	}

	public void setTopics(Integer topics) {
		this.topics = topics;
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

	public Integer getFocusFlag() {
		return focusFlag;
	}

	public void setFocusFlag(Integer focusFlag) {
		this.focusFlag = focusFlag;
	}
}
