package com.lsy.www.biz.user;

import java.sql.Date;

import com.kit.exception.BizException;

/**
 * Description:用户统计业务接口
 *
 * @version 1.0 2016年4月27日
 * @author LSY
 */
public interface LsyWwwUserStatsBiz {

	/**
	 * 增减登录数
	 * 
	 * @param userId
	 * @param date
	 * @param logins
	 * @throws BizException
	 */
	public void updownLogins(Integer userId, Date date, Integer logins) throws BizException;

	/**
	 * 增减任务数
	 * 
	 * @param userId
	 * @param date
	 * @param tasks
	 * @throws BizException
	 */
	public void updownTasks(Integer userId, Date date, Integer tasks) throws BizException;

	/**
	 * 增减小站数
	 * 
	 * @param userId
	 * @param date
	 * @param stations
	 * @throws BizException
	 */
	public void updownStations(Integer userId, Date date, Integer stations) throws BizException;

	/**
	 * 增减报名数
	 * 
	 * @param userId
	 * @param date
	 * @param applies
	 * @throws BizException
	 */
	public void updownApplies(Integer userId, Date date, Integer applies) throws BizException;

	/**
	 * 增减点赞数
	 * 
	 * @param userId
	 * @param date
	 * @param praises
	 * @throws BizException
	 */
	public void updownPraises(Integer userId, Date date, Integer praises) throws BizException;

	/**
	 * 增减评论数
	 * 
	 * @param userId
	 * @param date
	 * @param comments
	 * @throws BizException
	 */
	public void updownComments(Integer userId, Date date, Integer comments) throws BizException;

	/**
	 * 增减查看数
	 * 
	 * @param userId
	 * @param date
	 * @param views
	 * @throws BizException
	 */
	public void updownViews(Integer userId, Date date, Integer views) throws BizException;

	/**
	 * 增减精选数
	 * 
	 * @param userId
	 * @param date
	 * @param choices
	 * @throws BizException
	 */
	public void updownChoices(Integer userId, Date date, Integer choices) throws BizException;

	/**
	 * 增减获奖数
	 * 
	 * @param userId
	 * @param date
	 * @param awards
	 * @throws BizException
	 */
	public void updownAwards(Integer userId, Date date, Integer awards) throws BizException;

	/**
	 * 增减订阅数
	 * 
	 * @param userId
	 * @param date
	 * @param tags
	 * @throws BizException
	 */
	public void updownTags(Integer userId, Date date, Integer tags) throws BizException;

	/**
	 * 增减粉丝数
	 * 
	 * @param userId
	 * @param date
	 * @param fans
	 * @throws BizException
	 */
	public void updownFans(Integer userId, Date date, Integer fans) throws BizException;

	/**
	 * 增减关注数
	 * 
	 * @param userId
	 * @param date
	 * @param focus
	 * @throws BizException
	 */
	public void updownFocus(Integer userId, Date date, Integer focus) throws BizException;

	/**
	 * 增减主题数
	 * 
	 * @param userId
	 * @param date
	 * @param topics
	 * @throws BizException
	 */
	public void updownTopics(Integer userId, Date date, Integer topics) throws BizException;

	/**
	 * 增减照片数
	 * 
	 * @param userId
	 * @param date
	 * @param photos
	 * @throws BizException
	 */
	public void updownPhotos(Integer userId, Date date, Integer photos) throws BizException;

	/**
	 * 增减积分数
	 * 
	 * @param userId
	 * @param date
	 * @param points
	 * @throws BizException
	 */
	public void updownPoints(Integer userId, Date date, Integer points) throws BizException;

	/**
	 * 增减交易数
	 * 
	 * @param userId
	 * @param date
	 * @param trades
	 * @throws BizException
	 */
	public void updownTrades(Integer userId, Date date, Integer trades) throws BizException;

	/**
	 * 增减公告数
	 * 
	 * @param userId
	 * @param notices
	 * @throws BizException
	 */
	public void updownNotices(Integer userId, Integer notices) throws BizException;

	/**
	 * 增减事件数
	 * 
	 * @param userId
	 * @param events
	 * @throws BizException
	 */
	public void updownEvents(Integer userId, Integer events) throws BizException;

	/**
	 * 增减推荐数
	 * 
	 * @param userId
	 * @param newses
	 * @throws BizException
	 */
	public void updownNewses(Integer userId, Integer newses) throws BizException;

	/**
	 * 增减群聊数
	 * 
	 * @param userId
	 * @param groups
	 * @throws BizException
	 */
	public void updownGroups(Integer userId, Integer groups) throws BizException;

	/**
	 * 增减消息数
	 * 
	 * @param userId
	 * @param msgs
	 * @throws BizException
	 */
	public void updownMsgs(Integer userId, Integer msgs) throws BizException;

	/**
	 * 增减快拍之星次数
	 * 
	 * @param userId
	 * @param stars
	 * @throws BizException
	 */
	public void updownStars(Integer userId, Integer stars) throws BizException;

	/**
	 * 获取总照片数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotos() throws BizException;

	/**
	 * 获取某用户的照片数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotos(Integer userId) throws BizException;

	/**
	 * 获取指定日期照片数
	 * 
	 * @param date
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotos(Date date) throws BizException;

	/**
	 * 获取精选照片数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoChoices() throws BizException;

	/**
	 * 获取指定日期精选照片数
	 * 
	 * @param date
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoChoices(Date date) throws BizException;

	/**
	 * 获取某用户的精选照片数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoChoices(Integer userId) throws BizException;

	/**
	 * 获取每日之星照片数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoStars() throws BizException;

	/**
	 * 获取某用户的每日之星照片数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoStars(Integer userId) throws BizException;

	/**
	 * 获取获奖照片数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoAwards() throws BizException;

	/**
	 * 获取某用户的获奖照片数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getPhotoAwards(Integer userId) throws BizException;

	/**
	 * 获取组图数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getTopics() throws BizException;

	/**
	 * 获取组图数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getTopics(Integer userId) throws BizException;

	/**
	 * 获取任务数
	 * 
	 * @param userId
	 * @return
	 * @throws BizException
	 */
	public Integer getTasks(Integer userId) throws BizException;

	/**
	 * 获取公告数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getNotices(Integer userId) throws BizException;

	/**
	 * 获取事件数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getEvents(Integer userId) throws BizException;

	/**
	 * 获取私信数
	 * 
	 * @return
	 * @throws BizException
	 */
	public Integer getPrivates(Integer userId) throws BizException;
}
