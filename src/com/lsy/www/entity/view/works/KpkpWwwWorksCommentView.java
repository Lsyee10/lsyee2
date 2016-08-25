/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

/**
 * Description:作品评论视图
 * 
 * @version 1.0 2015年12月3日
 * @author Wu guang jing
 */
public class KpkpWwwWorksCommentView {

	private Integer commentId;
	private Integer userId;
	private String avatar;
	private String nickname;
	private String word;
	private String thumb;
	private String addTimeDes;

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

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getAddTimeDes() {
		return addTimeDes;
	}

	public void setAddTimeDes(String addTimeDes) {
		this.addTimeDes = addTimeDes;
	}

}
