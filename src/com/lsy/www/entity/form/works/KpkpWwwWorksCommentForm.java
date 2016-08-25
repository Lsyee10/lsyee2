/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.works;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:作品评论表单
 * 
 * @version 1.0 2015年12月3日
 * @author Wu guang jing
 */
public class KpkpWwwWorksCommentForm extends KpkpWwwBaseForm {

	private Integer commentId;
	private Integer userId;
	private Integer photoId;
	private Integer topicId;
	private Integer replyId;
	private String word;

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

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
