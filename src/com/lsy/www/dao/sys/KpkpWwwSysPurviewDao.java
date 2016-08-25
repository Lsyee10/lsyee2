/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.sys;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.sys.KpkpWwwSysPurviewCond;
import com.lsy.www.entity.model.sys.KpkpWwwSysPurview;

/**
 * Description:系统权限数据访问接口
 * 
 *@version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwSysPurviewDao extends LsyWwwBaseDao<KpkpWwwSysPurview, KpkpWwwSysPurviewCond> {

	/**
	 * 更新编码
	 * 
	 * @param purviewCond
	 * @return
	 * @throws DaoException
	 */
	public int updateCode(KpkpWwwSysPurviewCond purviewCond) throws DaoException;

	/**
	 * 更新级别
	 * 
	 * @param purviewCond
	 * @return
	 * @throws DaoException
	 */
	public int updateLevel(KpkpWwwSysPurviewCond purviewCond) throws DaoException;

}
