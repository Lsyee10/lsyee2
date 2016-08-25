/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.sys;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.sys.KpkpWwwSysPurviewCond;
import com.lsy.www.entity.model.sys.KpkpWwwSysPurview;

/**
 * Description:系统权限数据访问实现
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public class KpkpWwwSysPurviewDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwSysPurview, KpkpWwwSysPurviewCond>
		implements KpkpWwwSysPurviewDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.sys.KpkpWwwSysPurviewDao#updateCode(com.lsy.app.entity
	 * .cond.sys.KpkpWwwSysPurviewCond)
	 */
	public int updateCode(KpkpWwwSysPurviewCond purviewCond) throws DaoException {
		try {
			return this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateCode", purviewCond);
		} catch (RuntimeException e) {
			log.error("updateCode error", e);
			throw new DaoException("updateCode failure");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lsy.app.dao.sys.KpkpWwwSysPurviewDao#updateLevel(com.lsy.app.entity
	 * .cond.sys.KpkpWwwSysPurviewCond)
	 */
	public int updateLevel(KpkpWwwSysPurviewCond purviewCond) throws DaoException {
		try {
			return this.getSqlMapClientTemplate().update(this.sqlMapNamespace + ".updateLevel", purviewCond);
		} catch (RuntimeException e) {
			log.error("updateLevel error", e);
			throw new DaoException("updateLevel failure");
		}
	}

}
