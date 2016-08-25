/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.works;

import java.util.List;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.works.KpkpWwwWorksCommentCond;
import com.lsy.www.entity.model.works.KpkpWwwWorksComment;

/**
 * Description:评论数据访问接口
 * 
 * @version 1.0 2015年8月26日
 * @author Wu guang jing
 */
public interface KpkpWwwWorksCommentDao extends LsyWwwBaseDao<KpkpWwwWorksComment, KpkpWwwWorksCommentCond> {

	/**
	 * 查询某张照片的评论
	 * 
	 * @param photoId
	 * @param size
	 * @return
	 * @throws DaoException
	 */
	public List<KpkpWwwWorksComment> queryByPhoto(Integer photoId, Integer size) throws DaoException;
	
	/**
	 * 更新回收标示
	 * 
	 * @param commentId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer commentId, Integer recycleFlag) throws DaoException;
	
}
