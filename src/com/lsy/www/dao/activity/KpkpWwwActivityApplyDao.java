/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityApplyCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityApply;

/**
 * Description:活动报名数据访问接口
 *
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwActivityApplyDao extends LsyWwwBaseDao<KpkpWwwActivityApply, KpkpWwwActivityApplyCond> {

	/**
	 * 获取报名记录
	 * 
	 * @param activityId
	 * @param userId
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwActivityApply query(Integer activityId, Integer userId) throws DaoException;
}
