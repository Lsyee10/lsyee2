/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityVoteOptionCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityVoteOption;

/**
 * Description:活动评选选项接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwActivityVoteOptionDao extends
		LsyWwwBaseDao<KpkpWwwActivityVoteOption, KpkpWwwActivityVoteOptionCond> {
	
	/**
	 * 更新投票数
	 * 
	 * @param turnId
	 * @param photoId
	 * @throws DaoException
	 */
	public void updatePolls(Integer turnId, Integer photoId, Integer polls) throws DaoException;

}
