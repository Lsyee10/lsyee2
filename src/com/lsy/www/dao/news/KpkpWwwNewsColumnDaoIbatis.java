/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import org.springframework.stereotype.Repository;

import com.kit.exception.DaoException;
import com.lsy.util.SystemContext;
import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.news.KpkpWwwNewsColumnCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsColumn;

/**
 * Description:资讯栏目数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
@Repository(value = "kpkpWwwNewsColumnDao")
public class KpkpWwwNewsColumnDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwNewsColumn, KpkpWwwNewsColumnCond> implements
		KpkpWwwNewsColumnDao {

	KpkpWwwNewsColumnDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwNewsColumnMapper");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.dao.news.KpkpWwwNewsColumnDao#getCounts()
	 */
	public Integer getCounts() throws DaoException {
		KpkpWwwNewsColumnCond columnCond = null;
		KpkpWwwNewsColumn articleSum = null;
		try {
			// 获取文章总数
			columnCond = new KpkpWwwNewsColumnCond();
			columnCond.setRecycleFlag(SystemContext.YN.NO.getValue());
			columnCond.setStatsParam("sum(articles) as articles");
			articleSum = this.statsByCond(columnCond);

			// 如果统计存在
			if (null != articleSum) {
				return articleSum.getArticles();
			} else {
				return 0;
			}
		} catch (Exception e) {
			log.error("updateRecycle error", e);
			throw new DaoException("updateRecycle failure");
		} finally {
			columnCond = null;
			articleSum = null;
		}
	}
}
