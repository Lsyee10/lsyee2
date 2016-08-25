/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;

/**
 * Description:用户统计数据视图
 * 
 * @version 1.0 2016年2月18日
 * @author Chen ze tian
 */
public class KpkpWwwUserStatsSumView {

	private Integer msgs;
	private Integer privates;
	private Integer notices;
	private Integer events;

	public Integer getMsgs() {
		return msgs;
	}

	public void setMsgs(Integer msgs) {
		this.msgs = msgs;
	}

	public Integer getPrivates() {
		return privates;
	}

	public void setPrivates(Integer privates) {
		this.privates = privates;
	}

	public Integer getNotices() {
		return notices;
	}

	public void setNotices(Integer notices) {
		this.notices = notices;
	}

	public Integer getEvents() {
		return events;
	}

	public void setEvents(Integer events) {
		this.events = events;
	}

}
