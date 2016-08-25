/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserSubscribeCond;
import com.lsy.www.entity.model.user.KpkpWwwUserSubscribe;

/**
 * Description:用户标签订阅接口实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserSubscribeDao")
public class KpkpWwwUserSubscribeDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserSubscribe, KpkpWwwUserSubscribeCond>
		implements KpkpWwwUserSubscribeDao {

	public KpkpWwwUserSubscribeDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserSubscribeMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserSubscribeDao#queryByCond(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public KpkpWwwUserSubscribe queryByCond(Integer userId, Integer tagId) throws DaoException {
		KpkpWwwUserSubscribeCond subCond = null;
		List<KpkpWwwUserSubscribe> subs = null;
		try {

			// 获取用户关注列表
			subCond = new KpkpWwwUserSubscribeCond();
			subCond.setUserId(userId);
			subCond.setTagId(tagId);
			;
			subCond.setMaxResults(1);
			subCond.setFirstResult(0);
			subs = this.queryByCond(subCond);

			// 如果关注列表存在
			if (null != subs && !subs.isEmpty()) {
				return subs.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByCond error", e);
			throw new DaoException("queryByCond failure");
		} finally {
			subs = null;
			subCond = null;
		}
	}
}
