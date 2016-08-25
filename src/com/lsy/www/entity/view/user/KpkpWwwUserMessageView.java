/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.user;

/**
 * Description:用户消息统计项目视图
 * 
 * @version 1.0 2015年12月1日
 * @author Wu guang jing
 */
public class KpkpWwwUserMessageView {
	private Integer msgs;
	private Integer privates;
	private Integer notices;
	private Integer events;
	private Integer newses;
	private Integer groups;

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

	public Integer getNewses() {
		return newses;
	}

	public void setNewses(Integer newses) {
		this.newses = newses;
	}

	public Integer getGroups() {
		return groups;
	}

	public void setGroups(Integer groups) {
		this.groups = groups;
	}

}
