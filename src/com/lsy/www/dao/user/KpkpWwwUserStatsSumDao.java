/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.user;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.user.KpkpWwwUserStatsSumCond;
import com.lsy.www.entity.model.user.KpkpWwwUserStatsSum;

/**
 * Description:用户业务统计汇总接口
 * 
 * @version 1.0 2015年8月27日
 * @author Wu guang jing
 */
public interface KpkpWwwUserStatsSumDao extends LsyWwwBaseDao<KpkpWwwUserStatsSum, KpkpWwwUserStatsSumCond> {

	/**
	 * 更新照片数
	 * 
	 * @param userId
	 * @param photos
	 * @throws DaoException
	 */
	public void updatePhotos(Integer userId, Integer photos) throws DaoException;

	/**
	 * 更新任务数
	 * 
	 * @param userId
	 * @param tasks
	 * @throws DaoException
	 */
	public void updateTasks(Integer userId, Integer tasks) throws DaoException;

	/**
	 * 更新小站数
	 * 
	 * @param userId
	 * @param stations
	 * @throws DaoException
	 */
	public void updateStations(Integer userId, Integer stations) throws DaoException;

	/**
	 * 更新登录数
	 * 
	 * @param userId
	 * @param logins
	 * @throws DaoException
	 */
	public void updateLogins(Integer userId, Integer logins) throws DaoException;

	/**
	 * 更新评论数
	 * 
	 * @param userId
	 * @param comments
	 * @throws DaoException
	 */
	public void updateComments(Integer userId, Integer comments) throws DaoException;

	/**
	 * 更新点赞数
	 * 
	 * @param userId
	 * @param praises
	 * @throws DaoException
	 */
	public void updatePraises(Integer userId, Integer praises) throws DaoException;

	/**
	 * 更新访问数
	 * 
	 * @param userId
	 * @param views
	 * @throws DaoException
	 */
	public void updateViews(Integer userId, Integer views) throws DaoException;

	/**
	 * 更新组照数
	 * 
	 * @param userId
	 * @param topics
	 * @throws DaoException
	 */
	public void updateTopics(Integer userId, Integer topics) throws DaoException;

	/**
	 * 更新精选数
	 * 
	 * @param userId
	 * @param choices
	 * @throws DaoException
	 */
	public void updateChoices(Integer userId, Integer choices) throws DaoException;

	/**
	 * 更新获奖数
	 * 
	 * @param userId
	 * @param awards
	 * @throws DaoException
	 */
	public void updateAwards(Integer userId, Integer awards) throws DaoException;

	/**
	 * 更新交易数
	 * 
	 * @param userId
	 * @param points
	 * @throws DaoException
	 */
	public void updateTrades(Integer userId, Integer trades) throws DaoException;

	/**
	 * 更新订阅数
	 * 
	 * @param userId
	 * @param tags
	 * @throws DaoException
	 */
	public void updateTags(Integer userId, Integer tags) throws DaoException;

	/**
	 * 更新粉丝数
	 * 
	 * @param userId
	 * @param fans
	 * @throws DaoException
	 */
	public void updateFans(Integer userId, Integer fans) throws DaoException;

	/**
	 * 更新关注数
	 * 
	 * @param userId
	 * @param focus
	 * @throws DaoException
	 */
	public void updateFocus(Integer userId, Integer focus) throws DaoException;

	/**
	 * 更新报名数
	 * 
	 * @param userId
	 * @param applies
	 * @throws DaoException
	 */
	public void updateApplies(Integer userId, Integer applies) throws DaoException;

	/**
	 * 更新积分数
	 * 
	 * @param userId
	 * @param points
	 * @throws DaoException
	 */
	public void updatePoints(Integer userId, Integer points) throws DaoException;

	/**
	 * 更新公告数
	 * 
	 * @param userId
	 * @param notices
	 * @throws DaoException
	 */
	public void updateNotices(Integer userId, Integer notices) throws DaoException;

	/**
	 * 重置公告数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void resetNotices(Integer userId) throws DaoException;

	/**
	 * 更新事件数
	 * 
	 * @param userId
	 * @param events
	 * @throws DaoException
	 */
	public void updateEvents(Integer userId, Integer events) throws DaoException;

	/**
	 * 重置事件数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void resetEvents(Integer userId) throws DaoException;

	/**
	 * 重置私聊数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void resetPrivates(Integer userId) throws DaoException;

	/**
	 * 更新推荐数
	 * 
	 * @param userId
	 * @param newses
	 * @throws DaoException
	 */
	public void updateNewses(Integer userId, Integer newses) throws DaoException;

	/**
	 * 更新群聊数
	 * 
	 * @param userId
	 * @param groups
	 * @throws DaoException
	 */
	public void updateGroups(Integer userId, Integer groups) throws DaoException;

	/**
	 * 重置群聊数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void resetGroups(Integer userId) throws DaoException;

	/**
	 * 更新消息数
	 * 
	 * @param userId
	 * @param msgs
	 * @throws DaoException
	 */
	public void updateMsgs(Integer userId, Integer msgs) throws DaoException;

	/**
	 * 重置消息数
	 * 
	 * @param userId
	 * @throws DaoException
	 */
	public void resetMsgs(Integer userId) throws DaoException;

	/**
	 * 更新快拍之星次数
	 * 
	 * @param userId
	 * @param msgs
	 * @throws DaoException
	 */
	public void updateStars(Integer userId, Integer stars) throws DaoException;

	/**
	 * 更新私聊消息数
	 * 
	 * @param userId
	 * @param privates
	 * @throws DaoException
	 */
	public void updatePrivates(Integer userId, Integer privates) throws DaoException;
}
