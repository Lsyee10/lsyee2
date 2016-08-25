/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import com.kit.exception.DaoException;
import com.lsy.www.dao.LsyWwwBaseDao;
import com.lsy.www.entity.cond.news.KpkpWwwNewsColumnCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsColumn;

/**
 * Description:资讯栏目数据访问接口
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public interface KpkpWwwNewsColumnDao extends LsyWwwBaseDao<KpkpWwwNewsColumn, KpkpWwwNewsColumnCond> {

	/**
	 * 获取栏目文章总数
	 * 
	 * @return
	 * @throws DaoException
	 */
	public Integer getCounts() throws DaoException;
	
}
