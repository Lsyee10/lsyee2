/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksTopicCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksTopic;

/**
 * Description:作品主题接口
 *
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksTopicDao extends LsyWwwBaseDao<KpkpWwwWorksTopic, KpkpWwwWorksTopicCond>{

	/**
	 * 更新点赞数
	 * 
	 * @param userId
	 * @param praises
	 * @throws DaoException
	 */
	public void updatePraises(Integer topicId, Integer praises) throws DaoException;

	/**
	 * 更新点赞数
	 * 
	 * @param userId
	 * @param comments
	 * @throws DaoException
	 */
	public void updateComments(Integer topicId, Integer comments) throws DaoException;
	
	/**
	 * 更新回收标示
	 * 
	 * @param topicId
	 * @param comments
	 * @throws DaoException
	 */
	public void updateRecycle(Integer topicId, Integer recycleFlag) throws DaoException; 
}
