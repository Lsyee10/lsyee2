/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserFocusCond;
import com.lsy.www.entity.model.user.KpkpWwwUserFocus;

/**
 * Description:用户关注数据访问接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserFocusDao extends LsyWwwBaseDao<KpkpWwwUserFocus, KpkpWwwUserFocusCond> {
	
	/**
	 * 查询用户关注
	 * 
	 * @param userId
	 * @param shooterId
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserFocus queryByCond(Integer userId, Integer shooterId) throws DaoException;
	
	/**
	 * 连接查询
	 * 
	 * @param focusCond
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwUserFocus> queryByJoin(KpkpWwwUserFocusCond focusCond) throws DaoException;
}
