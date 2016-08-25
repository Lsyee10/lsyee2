/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPraiseCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPraise;

/**
 * Description:作品点赞数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksPraiseDao extends LsyWwwBaseDao<KpkpWwwWorksPraise, KpkpWwwWorksPraiseCond> {
	
	
	/**
	 * 查询点赞记录
	 * 
	 * @param userId
	 * @param photoId
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwWorksPraise queryByCond(Integer userId, Integer photoId) throws DaoException;
	

	/**
	 * 与用户账号连接查询
	 * 
	 * @param praiseCond
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPraise> queryByJoin(KpkpWwwWorksPraiseCond praiseCond) throws DaoException;
}
