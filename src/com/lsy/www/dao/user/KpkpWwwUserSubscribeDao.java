/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserSubscribeCond;
import com.lsy.www.entity.model.user.KpkpWwwUserSubscribe;

/**
 * Description:用户标签订阅接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserSubscribeDao extends LsyWwwBaseDao<KpkpWwwUserSubscribe, KpkpWwwUserSubscribeCond> {

	
	/**
	 * 查询订阅
	 * 
	 * @param userId
	 * @param tagId
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwUserSubscribe queryByCond(Integer userId, Integer tagId) throws DaoException;
}
