/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Date;

/**
 * Description:用户业务日统计
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserStatsDay implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private Date date;
	private Integer logins;
	private Integer tasks;
	private Integer stations;
	private Integer applies;
	private Integer praises;
	private Integer comments;
	private Integer views;
	private Integer choices;
	private Integer awards;
	private Integer tags;
	private Integer fans;
	private Integer focus;
	private Integer topics;
	private Integer photos;
	private Integer points;
	private Integer trades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLogins() {
		return logins;
	}

	public void setLogins(Integer logins) {
		this.logins = logins;
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

	public Integer getApplies() {
		return applies;
	}

	public void setApplies(Integer applies) {
		this.applies = applies;
	}

	public Integer getPraises() {
		return praises;
	}

	public void setPraises(Integer praises) {
		this.praises = praises;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
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

	public Integer getTopics() {
		return topics;
	}

	public void setTopics(Integer topics) {
		this.topics = topics;
	}

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getTrades() {
		return trades;
	}

	public void setTrades(Integer trades) {
		this.trades = trades;
	}

}