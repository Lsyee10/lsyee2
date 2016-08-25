/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityApplyCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityApply;

/**
 * Description:活动报名数据访问实现
 *
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwActivityApplyDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwActivityApply, KpkpWwwActivityApplyCond>
		implements KpkpWwwActivityApplyDao {

	public KpkpWwwActivityApply query(Integer activityId, Integer userId) throws DaoException {
		List<KpkpWwwActivityApply> applies = null;
		KpkpWwwActivityApplyCond applyCond = null;
		try {
			// 获取用户报名信息
			applyCond = new KpkpWwwActivityApplyCond();
			applyCond.setActivityId(activityId);
			applyCond.setUserId(userId);
			applyCond.setFirstResult(0);
			applyCond.setMaxResults(1);
			applies = this.queryByCond(applyCond);

			// 如果报名记录存在
			if (null != applies && !applies.isEmpty()) {
				return applies.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("query error", e);
			throw new DaoException("query failure");
		} finally {
			applies = null;
			applyCond = null;
		}
	}
}
