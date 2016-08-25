/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityVoteOptionCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityVoteOption;

/**
 * Description:活动评选选项接口实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwActivityVoteOptionDaoIbatis extends
		LsyWwwBaseDaoIbatis<KpkpWwwActivityVoteOption, KpkpWwwActivityVoteOptionCond> implements
		KpkpWwwActivityVoteOptionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.www.dao.activity.KpkpWwwActivityVoteOptionDao#updatePoll(java
	 * .lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void updatePolls(Integer turnId, Integer photoId, Integer polls) throws DaoException {
		KpkpWwwActivityVoteOptionCond optionCond = null;
		try {
			optionCond = new KpkpWwwActivityVoteOptionCond();
			optionCond.setTurnId(turnId);
			optionCond.setPhotoId(photoId);
			optionCond.setUpdateParam("polls = polls +(" + polls + ")");
			this.updateByCond(optionCond);
		} catch (RuntimeException e) {
			log.error("updatePolls error", e);
			throw new DaoException("updatePolls failure");
		} finally {
			optionCond = null;
		}
	}

}
