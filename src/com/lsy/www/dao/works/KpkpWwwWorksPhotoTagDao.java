/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksPhotoTagCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksPhotoTag;

/**
 * Description:作品照片标签数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksPhotoTagDao extends LsyWwwBaseDao<KpkpWwwWorksPhotoTag, KpkpWwwWorksPhotoTagCond> {

	/**
	 * 根据照片ID删除标签关系
	 * 
	 * @param photoId
	 * @throws DaoException
	 */
	public void delete(Integer photoId) throws DaoException;
	
	/**
	 * 获取某照片的标签关系
	 * 
	 * @param photoId
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksPhotoTag> query(Integer photoId) throws DaoException;
}
