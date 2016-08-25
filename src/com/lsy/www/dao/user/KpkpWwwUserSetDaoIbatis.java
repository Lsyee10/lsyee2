/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.user.KpkpWwwUserSetCond;
import com.lsy.www.entity.model.user.KpkpWwwUserSet;

/**
 * Description:用户设置数据访问实现
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
@Repository("kpkpWwwUserSetDao")
public class KpkpWwwUserSetDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwUserSet, KpkpWwwUserSetCond> implements
		KpkpWwwUserSetDao {

	public KpkpWwwUserSetDaoIbatis() {
		super.setSqlMapNamespace("kpkpWwwUserSetDao");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.app.dao.user.KpkpWwwUserSetDao#updateIos(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public void updateIos(Integer userId, String ios) throws DaoException {
		KpkpWwwUserSet set = null;
		try {
			set = new KpkpWwwUserSet();
			set.setUserId(userId);
			set.setIos(ios);
			this.update(set);
		} catch (Exception e) {
			log.error("updateIos error", e);
			throw new DaoException("updateIos failure");
		} finally {
			set = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.user.KpkpWwwUserSetDao#updateAndroid(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public void updateAndroid(Integer userId, String android) throws DaoException {
		KpkpWwwUserSet set = null;
		try {
			set = new KpkpWwwUserSet();
			set.setUserId(userId);
			set.setAndroid(android);
			this.update(set);
		} catch (Exception e) {
			log.error("updateAndroid error", e);
			throw new DaoException("updateAndroid failure");
		} finally {
			set = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.user.KpkpWwwUserSetDao#updateWeb(java.lang.Integer,
	 * java.lang.String)
	 */
	@Override
	public void updateWeb(Integer userId, String web) throws DaoException {
		KpkpWwwUserSet set = null;
		try {
			set = new KpkpWwwUserSet();
			set.setUserId(userId);
			set.setWeb(web);
			this.update(set);
		} catch (Exception e) {
			log.error("updateWeb error", e);
			throw new DaoException("updateWeb failure");
		} finally {
			set = null;
		}

	}

}
