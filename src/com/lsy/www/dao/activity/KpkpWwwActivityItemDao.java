/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.activity;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.activity.KpkpWwwActivityItemCond;
import com.lsy.www.entity.model.activity.KpkpWwwActivityItem;

/**
 * Description:活动项目数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwActivityItemDao extends LsyWwwBaseDao<KpkpWwwActivityItem, KpkpWwwActivityItemCond> {

	/**
	 * 根据标签查询活动项目
	 * 
	 * @param tag
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwActivityItem queryByTag(String tag) throws DaoException;

	/**
	 * 根据推荐查询活动项目
	 * 
	 * @param actvityPushId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwActivityItem> queryByTop(Integer topFlag, Integer size) throws DaoException;

	/**
	 * 根据推荐查询活动项目
	 * 
	 * @param topFlag
	 * @param bizFlag
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwActivityItem> queryByTop(Integer topFlag, Integer bizFlag, Integer size) throws DaoException;

	/**
	 * 更新照片数
	 * 
	 * @param activityId
	 * @param photos
	 * @throws DaoException
	 */
	public void updownPhotos(Integer activityId, Integer photos) throws DaoException;

	/**
	 * 更新参加人数
	 * 
	 * @param activityId
	 * @param joins
	 * @throws DaoException
	 */
	public void updownJoins(Integer activityId, Integer joins) throws DaoException;
}
