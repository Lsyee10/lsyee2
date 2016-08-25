/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.news;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:资讯项目条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsItemCond extends KpkpWwwBaseCond {

	private Integer newsId;
	private Integer excludeNewsId;
	private Integer columnId;
	private Integer excludeColumnId; // 不显示的栏目
	private Integer userId;
	private Integer topFlag;
	private String title;
	private Integer pubFlag;
	private Integer replyFlag;
	private Integer imageFlag;
	private Integer videoFlag;
	private Integer recycleFlag;
	private Integer masterId;
	private String tagRelate; // 标签匹配文章
	private String tagName;
	private Integer columnFlag;

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getExcludeNewsId() {
		return excludeNewsId;
	}

	public void setExcludeNewsId(Integer excludeNewsId) {
		this.excludeNewsId = excludeNewsId;
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

	public Integer getTopFlag() {
		return topFlag;
	}

	public void setTopFlag(Integer topFlag) {
		this.topFlag = topFlag;
	}

	public Integer getPubFlag() {
		return pubFlag;
	}

	public void setPubFlag(Integer pubFlag) {
		this.pubFlag = pubFlag;
	}

	public Integer getReplyFlag() {
		return replyFlag;
	}

	public void setReplyFlag(Integer replyFlag) {
		this.replyFlag = replyFlag;
	}

	public Integer getImageFlag() {
		return imageFlag;
	}

	public void setImageFlag(Integer imageFlag) {
		this.imageFlag = imageFlag;
	}

	public Integer getVideoFlag() {
		return videoFlag;
	}

	public void setVideoFlag(Integer videoFlag) {
		this.videoFlag = videoFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTagRelate() {
		return tagRelate;
	}

	public void setTagRelate(String tagRelate) {
		this.tagRelate = tagRelate;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getColumnFlag() {
		return columnFlag;
	}

	public void setColumnFlag(Integer columnFlag) {
		this.columnFlag = columnFlag;
	}

	public Integer getExcludeColumnId() {
		return excludeColumnId;
	}

	public void setExcludeColumnId(Integer excludeColumnId) {
		this.excludeColumnId = excludeColumnId;
	}

}