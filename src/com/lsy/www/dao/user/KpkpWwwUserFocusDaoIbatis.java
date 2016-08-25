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
import com.lsy.www.entity.cond.user.KpkpWwwUserFocusCond;
import com.lsy.www.entity.model.user.KpkpWwwUserFocus;

/**
 * Description:用户关注数据访问接口实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserFocusDao")
public class KpkpWwwUserFocusDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserFocus, KpkpWwwUserFocusCond> implements
		KpkpWwwUserFocusDao {

	public KpkpWwwUserFocusDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwUserFocusMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserFocusDao#queryByCond(java.lang.Integer,
	 * java.lang.Integer)
	 */
	public KpkpWwwUserFocus queryByCond(Integer userId, Integer shooterId) throws DaoException {
		KpkpWwwUserFocusCond focusCond = null;
		List<KpkpWwwUserFocus> focuses = null;
		try {
			// 获取用户关注列表
			focusCond = new KpkpWwwUserFocusCond();
			focusCond.setUserId(userId);
			focusCond.setShooterId(shooterId);
			focusCond.setMaxResults(1);
			focusCond.setFirstResult(0);
			focuses = this.queryByCond(focusCond);

			// 如果关注列表存在
			if (null != focuses && !focuses.isEmpty()) {
				return focuses.get(0);
			}

			return null;
		} catch (Exception e) {
			log.error("queryByCond error", e);
			throw new DaoException("queryByCond failure");
		} finally {
			focuses = null;
			focusCond = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserFocusDao#querybyJoin(com.lsy.app.entity
	 * .cond.user.KpkpWwwUserFocusCond)
	 */
	@SuppressWarnings("unchecked")
	public List<KpkpWwwUserFocus> queryByJoin(KpkpWwwUserFocusCond focusCond) throws DaoException {
		try {
			return (List<KpkpWwwUserFocus>) this.getSqlMapClientTemplate().queryForList(
					this.sqlMapNamespace + ".queryByJoin", focusCond);
		} catch (RuntimeException e) {
			log.error("queryByCond error", e);
			throw new DaoException("queryByCond failure");
		}
	}
}
