/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.news;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:资讯投票主题条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsVoteCond extends KpkpWwwBaseCond {

	private Integer voteId;
	private Integer newsId;
	private String name;
	private Integer ruleFlag;
	private Integer selectFlag;
	private Integer recycleFlag;

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

}
