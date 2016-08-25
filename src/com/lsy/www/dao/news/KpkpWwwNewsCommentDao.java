/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.news.KpkpWwwNewsCommentCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsComment;

/**
 * Description:资讯评论数据访问接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwNewsCommentDao extends LsyWwwBaseDao<KpkpWwwNewsComment, KpkpWwwNewsCommentCond> {

	/**
	 * 更新回收标示
	 * 
	 * @param commentId
	 * @param recycleFlag
	 * @throws DaoException
	 */
	public void updateRecycle(Integer commentId, Integer recycleFlag) throws DaoException;
	
}
