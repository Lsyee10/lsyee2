/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksTagCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksTag;

/**
 * Description:作品标签数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksTagDao extends LsyWwwBaseDao<KpkpWwwWorksTag, KpkpWwwWorksTagCond> {
	
	/**
	 * 获取标签
	 * 
	 * @param name
	 * @return
	 * @throws DaoException
	 */
	public KpkpWwwWorksTag queryByName(String name) throws DaoException;

	/**
	 * 获取推荐标签
	 * 
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksTag> queryByTop(Integer topFlag, Integer size) throws DaoException;
	
	/**
	 * 获取照片标签
	 * 
	 * @param photoId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksTag> queryByPhoto(Integer photoId, Integer size) throws DaoException;
	
	/**
	 * 获取用户订阅的标签
	 * 
	 * @param subUserId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksTag> queryBySub(Integer subUserId, Integer size) throws DaoException;
	
	/**
	 * 获取用户使用的标签
	 * 
	 * @param useUserId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksTag> queryByUse(Integer useUserId, Integer size) throws DaoException;
	
	/**
	 * 增减用户数
	 * 
	 * @param tag
	 * @param users
	 * @throws DaoException
	 */
	public void updownUsers(Integer tagId, Integer users) throws DaoException;

	/**
	 * 增减照片数
	 * 
	 * @param tag
	 * @param photos
	 * @throws DaoException
	 */
	public void updownPhotos(Integer tagId, Integer photos) throws DaoException;
}
