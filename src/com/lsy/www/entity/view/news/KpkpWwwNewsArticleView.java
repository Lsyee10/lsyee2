/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.news;


/**
 * Description:资讯文章视图
 * 
 * @version 1.0 2015年12月2日
 * @author Wu guang jing
 */
public class KpkpWwwNewsArticleView {

	private Integer newsId;
	private Integer columnId;
	private Integer userId;
	private String title;
	private String author;
	private String summary;
	private String cover1;
	private String cover2;
	private String tag;
	private Integer views;
	private Integer comments;
	private String columnName;
	private String content;
	private String pubDateDes;

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getCover1() {
		return cover1;
	}

	public void setCover1(String cover1) {
		this.cover1 = cover1;
	}

	public String getCover2() {
		return cover2;
	}

	public void setCover2(String cover2) {
		this.cover2 = cover2;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPubDateDes() {
		return pubDateDes;
	}

	public void setPubDateDes(String pubDateDes) {
		this.pubDateDes = pubDateDes;
	}

}
