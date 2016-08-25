/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.news;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:资讯投票主题
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsVote implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer voteId;
	private Integer newsId;
	private String name;
	private Integer ruleFlag;
	private Integer selectFlag;
	private Integer recycleFlag;
	private Timestamp addTime;


	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRuleFlag() {
		return ruleFlag;
	}

	public void setRuleFlag(Integer ruleFlag) {
		this.ruleFlag = ruleFlag;
	}

	public Integer getSelectFlag() {
		return selectFlag;
	}

	public void setSelectFlag(Integer selectFlag) {
		this.selectFlag = selectFlag;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

}
