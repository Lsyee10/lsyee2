/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.news;

/**
 * Description:资讯文章评论视图
 * 
 * @version 1.0 2015年12月2日
 * @author Wu guang jing
 */
public class KpkpWwwNewsCommentView {

	private Integer newsId;
	private Integer commentId;
	private Integer reId;
	private Integer userId;
	private String content;
	private String addTimeDes;
	private String nickname;
	private String avatar;

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
