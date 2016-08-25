/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.news;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:资讯文章评论表单
 * 
 * @version 1.0 2015年12月2日
 * @author Wu guang jing
 */

public class KpkpWwwNewsCommentForm extends KpkpWwwBaseForm {

	private Integer commentId;
	private Integer userId;
	private Integer reId;
	private Integer newsId;
	private String content;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
