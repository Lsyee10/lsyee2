/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPraiseCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPraise;

/**
 * Description:作品点赞数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
@Repository("kpkpWwwWorksPraiseDao")
public class KpkpWwwWorksPraiseDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwWorksPraise, KpkpWwwWorksPraiseCond>
		implements KpkpWwwWorksPraiseDao {

	public KpkpWwwWorksPraiseDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwWorksPraiseMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPraiseDao#queryByCond(java.lang.Integer
	 * , java.lang.Integer)
	 */
	public KpkpWwwWorksPraise queryByCond(Integer userId, Integer photoId) throws DaoException {
		KpkpWwwWorksPraiseCond praiseCond = null;
		List<KpkpWwwWorksPraise> praises = null;
		try {
			praiseCond = new KpkpWwwWorksPraiseCond();
			praiseCond.setUserId(userId);
			praiseCond.setPhotoId(photoId);
			praiseCond.setFirstResult(0);
			praiseCond.setMaxResults(1);
			praises = this.queryByCond(praiseCond);

			// 如果点赞记录存在
			if (null != praises && !praises.isEmpty()) {
				return praises.get(0);
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error("queryByCond error", e);
			throw new DaoException("queryByCond failure");
		} finally {
			praises = null;
			praiseCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.works.KpkpWwwWorksPraiseDao#queryByUserAccount(com.lsy
	 * .app.entity.cond.works.KpkpWwwWorksPraiseCond)
	 */
	@SuppressWarnings("unchecked")
	public List<KpkpWwwWorksPraise> queryByJoin(KpkpWwwWorksPraiseCond praiseCond) throws DaoException {
		try {
			return (List<KpkpWwwWorksPraise>) this.getSqlMapClientTemplate().queryForList(
					this.sqlMapNamespace + ".queryByJoin", praiseCond);
		} catch (RuntimeException e) {
			log.error("queryByCond error", e);
			throw new DaoException("queryByCond failure");
		}
	}
}
