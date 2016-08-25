/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.news;

import java.io.Serializable;

/**
 * Description:资讯栏目
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsColumn implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer columnId;
	private Integer userId;
	private String name;
	private Integer articles;
	private Integer recycleFlag;

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRecycleFlag() {
		return recycleFlag;
	}

	public void setRecycleFlag(Integer recycleFlag) {
		this.recycleFlag = recycleFlag;
	}

	public Integer getArticles() {
		return articles;
	}

	public void setArticles(Integer articles) {
		this.articles = articles;
	}

}
