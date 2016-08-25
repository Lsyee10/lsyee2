/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.dao.news;

import org.springframework.stereotype.Repository;

import com.lsy.www.dao.LsyWwwBaseDaoIbatis;
import com.lsy.www.entity.cond.news.KpkpWwwNewsArticleCond;
import com.lsy.www.entity.model.news.KpkpWwwNewsArticle;

/**
 * Description:资讯文章数据访问实现
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
@Repository(value = "kpkpWwwNewsArticleDao")
public class KpkpWwwNewsArticleDaoIbatis extends LsyWwwBaseDaoIbatis<KpkpWwwNewsArticle, KpkpWwwNewsArticleCond>
		implements KpkpWwwNewsArticleDao {

	public KpkpWwwNewsArticleDaoIbatis() {
		super.setSqlMapNamespace("KpkpWwwNewsArticleMapper");
	}

}
