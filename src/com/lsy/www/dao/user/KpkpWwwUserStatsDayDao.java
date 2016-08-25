/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import java.sql.Date;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsDayCond;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsDay;

/**
 * Description:用户业务日统计数据访问接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserStatsDayDao extends LsyWwwBaseDao<KpkpWwwUserStatsDay, KpkpWwwUserStatsDayCond> {
	
	/**
	 * 更新登录数
	 * 
	 * @param userId
	 * @param logins
	 * @param date
	 * @throws DaoException
	 */
	public void updateLogins(Integer userId, Integer logins, Date date) throws DaoException;

	/**
	 * 更新任务数
	 * 
	 * @param userId
	 * @param tasks
	 * @param date
	 * @throws DaoException
	 */
	public void updateTasks(Integer userId, Integer tasks, Date date) throws DaoException;

	/**
	 * 更新小站数
	 * 
	 * @param userId
	 * @param stations
	 * @param date
	 * @throws DaoException
	 */
	public void updateStations(Integer userId, Integer stations, Date date) throws DaoException;

	/**
	 * 更新报名数
	 * 
	 * @param userId
	 * @param applies
	 * @param date
	 * @throws DaoException
	 */
	public void updateApplies(Integer userId, Integer applies, Date date) throws DaoException;
	
	/**
	 * 更新点赞数
	 * 
	 * @param userId
	 * @param praises
	 * @param date
	 * @throws DaoException
	 */
	public void updatePraises(Integer userId, Integer praises, Date date) throws DaoException;

	/**
	 * 更新评论数
	 * 
	 * @param userId
	 * @param comments
	 * @param date
	 * @throws DaoException
	 */
	public void updateComments(Integer userId, Integer comments, Date date) throws DaoException;

	/**
	 * 更新访问数
	 * 
	 * @param userId
	 * @param views
	 * @param date
	 * @throws DaoException
	 */
	public void updateViews(Integer userId, Integer views, Date date) throws DaoException;

	/**
	 * 更新精选数
	 * 
	 * @param userId
	 * @param choices
	 * @param date
	 * @throws DaoException
	 */
	public void updateChoices(Integer userId, Integer choices, Date date) throws DaoException;

	/**
	 * 更新获奖数
	 * 
	 * @param userId
	 * @param awards
	 * @param date
	 * @throws DaoException
	 */
	public void updateAwards(Integer userId, Integer awards, Date date) throws DaoException;

	/**
	 * 更新订阅数
	 * 
	 * @param userId
	 * @param tags
	 * @param date
	 * @throws DaoException
	 */
	public void updateTags(Integer userId, Integer tags, Date date) throws DaoException;

	/**
	 * 更新粉丝数
	 * 
	 * @param userId
	 * @param fans
	 * @param date
	 * @throws DaoException
	 */
	public void updateFans(Integer userId, Integer fans, Date date) throws DaoException;

	/**
	 * 更新关注数
	 * 
	 * @param userId
	 * @param focus
	 * @param date
	 * @throws DaoException
	 */
	public void updateFocus(Integer userId, Integer focus, Date date) throws DaoException;

	/**
	 * 更新组照数
	 * 
	 * @param userId
	 * @param topics
	 * @param date
	 * @throws DaoException
	 */
	public void updateTopics(Integer userId, Integer topics, Date date) throws DaoException;

	/**
	 * 更新照片数
	 * 
	 * @param userId
	 * @param photos
	 * @param date
	 * @throws DaoException
	 */
	public void updatePhotos(Integer userId, Integer photos, Date date) throws DaoException;

	/**
	 * 更新积分数
	 * 
	 * @param userId
	 * @param points
	 * @param date
	 * @throws DaoException
	 */
	public void updatePoints(Integer userId, Integer points, Date date) throws DaoException;

	/**
	 * 更新交易数
	 * 
	 * @param userId
	 * @param points
	 * @param date
	 * @throws DaoException
	 */
	public void updateTrades(Integer userId, Integer trades, Date date) throws DaoException;
}
