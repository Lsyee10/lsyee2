/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPhotoCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhoto;

/**
 * Description:照片数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksPhotoDao extends LsyWwwBaseDao<KpkpWwwWorksPhoto, KpkpWwwWorksPhotoCond> {
	
	/**
	 * 查询最新照片
	 * 
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByNewest(Integer size) throws DaoException;
	
	/**
	 * 查询某城市的照片
	 * 
	 * @param city
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByCity(String city, Integer size) throws DaoException;

	/**
	 * 查询某标签的照片
	 * 
	 * @param tagName
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByTag(Integer tagId, Integer size) throws DaoException;

	/**
	 * 查询某用户的照片
	 * 
	 * @param userId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByUser(Integer userId, Integer size) throws DaoException;
	
	/**
	 * 查询被编辑（精选、获奖）的照片
	 * 
	 * @param addTimeSt
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByEdit(String startAddTime, Integer size) throws DaoException; 

	/**
	 * 查询精选的照片
	 * 
	 * @param choiceFlag
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByChoice(Integer choiceFlag, Integer size) throws DaoException;
	
	/**
	 * 查询每日之星的照片
	 * 
	 * @param starFlag
	 * @param starDate
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByStar(Integer starFlag, String starDate) throws DaoException;
	
	/**
	 * 查询某任务的照片
	 * 
	 * @param taskId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByTask(Integer taskId, Integer size) throws DaoException;
	
	/**
	 * 查询某小站的照片
	 * 
	 * @param stationId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByStation(Integer stationId, Integer size) throws DaoException;
	
	/**
	 * 查询某附近的照片
	 * 
	 * @param leftTopPointLat
	 * @param leftTopPointLng
	 * @param rightBotPointLat
	 * @param rightBotPointLng
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhoto> queryByNearby(double leftTopPointLat, double leftTopPointLng,
			double rightBotPointLat, double rightBotPointLng, Integer size) throws DaoException;

	/**
	 * 更新点赞数
	 * 
	 * @param photoId
	 * @param praises
	 * @throws DaoException
	 */
	public void updatePraises(Integer photoId, Integer praises) throws DaoException;

	/**
	 * 更新评论数
	 * 
	 * @param photoId
	 * @param comments
	 * @throws DaoException
	 */
	public void updateComments(Integer photoId, Integer comments) throws DaoException;
	
	/**
	 * 更新回收标示
	 * 
	 * @param topicId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer topicId, Integer recycleFlag) throws DaoException;
	
	/**
	 * 更新任务id
	 * 
	 * @param topicId
	 * @param taskId
	 * @throws DaoException
	 */
	public void updateTask(Integer topicId, Integer taskId) throws DaoException;
	
	/**
	 * 更新小站id
	 * 
	 * @param topicId
	 * @param stationId
	 * @throws DaoException
	 */
	public void updateStation(Integer topicId, Integer stationId) throws DaoException;
}
