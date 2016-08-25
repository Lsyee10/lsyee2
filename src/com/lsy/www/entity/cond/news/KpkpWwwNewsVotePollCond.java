/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.news;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:资讯投票情况条件
 * 
 * @version 1.0 2015年8月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsVotePollCond extends KpkpWwwBaseCond {

	private Integer pollId;
	private Integer newsId;
	private Integer voteId;
	private Integer optionId;
	private Integer userId;

	public Integer getPollId() {
		return pollId;
	}

	public void setPollId(Integer pollId) {
		this.pollId = pollId;
	}

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public Integer getVoteId() {
		return voteId;
	}

	public void setVoteId(Integer voteId) {
		this.voteId = voteId;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
