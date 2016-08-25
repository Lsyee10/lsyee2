/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;

/**
 * Description:用户业务统计汇总
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserStatsSum implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer userId;
	private Integer photos;
	private Integer tasks;
	private Integer stations;
	private Integer logins;
	private Integer comments;
	private Integer praises;
	private Integer views;
	private Integer topics;
	private Integer choices;
	private Integer awards;
	private Integer trades;
	private Integer tags;
	private Integer fans;
	private Integer focus;
	private Integer applies;
	private Integer points;
	private Integer notices;
	private Integer events;
	private Integer newses;
	private Integer groups;
	private Integer msgs;
	private Integer stars;
	private Integer privates;

	// 与用户联合查询
	private String nickname;
	private String intro;
	private String avatar;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getTasks() {
		return tasks;
	}

	public void setTasks(Integer tasks) {
		this.tasks = tasks;
	}

	public Integer getStations() {
		return stations;
	}

	public void setStations(Integer stations) {
		this.stations = stations;
	}

	public Integer getLogins() {
		return logins;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getPraises() {
		return praises;
	}

	public void setPraises(Integer praises) {
		this.praises = praises;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getTopics() {
		return topics;
	}

	public void setTopics(Integer topics) {
		this.topics = topics;
	}

	public Integer getChoices() {
		return choices;
	}

	public void setChoices(Integer choices) {
		this.choices = choices;
	}

	public Integer getAwards() {
		return awards;
	}

	public void setAwards(Integer awards) {
		this.awards = awards;
	}

	public Integer getTrades() {
		return trades;
	}

	public void setTrades(Integer trades) {
		this.trades = trades;
	}

	public Integer getTags() {
		return tags;
	}

	public void setTags(Integer tags) {
		this.tags = tags;
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

	public Integer getApplies() {
		return applies;
	}

	public void setApplies(Integer applies) {
		this.applies = applies;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
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

	public Integer getMsgs() {
		return msgs;
	}

	public void setMsgs(Integer msgs) {
		this.msgs = msgs;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Integer getPrivates() {
		return privates;
	}

	public void setPrivates(Integer privates) {
		this.privates = privates;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}