/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.user;

/**
 * Description:用户设置表单
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwUserSettingForm {

	private Integer userId;
	private boolean praiseFlag;
	private boolean commentFlag;
	private boolean focusFlag;
	private boolean awardFlag;
	private boolean choiceFlag;
	private boolean callFlag;
	private boolean starFlag;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPraiseFlag() {
		return praiseFlag == true ? 1 : 0;
	}

	public void setPraiseFlag(boolean praiseFlag) {
		this.praiseFlag = praiseFlag;
	}

	public Integer getCommentFlag() {
		return commentFlag == true ? 1 : 0;
	}

	public void setCommentFlag(boolean commentFlag) {
		this.commentFlag = commentFlag;
	}

	public Integer getFocusFlag() {
		return focusFlag == true ? 1 : 0;
	}

	public void setFocusFlag(boolean focusFlag) {
		this.focusFlag = focusFlag;
	}

	public Integer getAwardFlag() {
		return awardFlag == true ? 1 : 0;
	}

	public void setAwardFlag(boolean awardFlag) {
		this.awardFlag = awardFlag;
	}

	public Integer getChoiceFlag() {
		return choiceFlag == true ? 1 : 0;
	}

	public void setChoiceFlag(boolean choiceFlag) {
		this.choiceFlag = choiceFlag;
	}

	public Integer getCallFlag() {
		return callFlag == true ? 1 : 0;
	}

	public void setCallFlag(boolean callFlag) {
		this.callFlag = callFlag;
	}

	public Integer getStarFlag() {
		return starFlag == true ? 1 : 0;
	}

	public void setStarFlag(boolean starFlag) {
		this.starFlag = starFlag;
	}
}
