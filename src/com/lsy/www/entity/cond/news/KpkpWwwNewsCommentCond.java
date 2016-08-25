/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.news;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:资讯评论条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsCommentCond extends KpkpWwwBaseCond {

	private Integer commentId;
	private Integer reId;
	private Integer userId;
	private Integer recycleFlag;
	private Integer newsId;

	// 获取用户资料标示，用于连接查询
	private Integer profileFlag;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getProfileFlag() {
		return profileFlag;
	}

	public void setProfileFlag(Integer profileFlag) {
		this.profileFlag = profileFlag;
	}

}