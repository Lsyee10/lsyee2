/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.activity;

import java.io.Serializable;

/**
 * Description:活动详细
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwActivityIntro implements Serializable {
	private static final long serialVersionUID = 1L;

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
