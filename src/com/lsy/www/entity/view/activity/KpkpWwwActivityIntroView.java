/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

/**
 * Description:活动介绍视图
 *
 * @version 1.0 2015年12月30日
 * @author Wu guang jing
 */
public class KpkpWwwActivityIntroView {

	private Integer introId;
	private Integer activityId;
	private String title;
	private String content;

	public Integer getIntroId() {
		return introId;
	}

	public void setIntroId(Integer introId) {
		this.introId = introId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
