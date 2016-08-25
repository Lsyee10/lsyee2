/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.news;

/**
 * Description:资讯栏目视图
 * 
 * @version 1.0 2016年1月18日
 * @author Chen ze tian
 */
public class KpkpWwwNewsColumnView {

	private Integer columnId;
	private Integer articles;
	private String name;

	public Integer getColumnId() {
		return columnId;
	}

	public void setColumnId(Integer columnId) {
		this.columnId = columnId;
	}

	public Integer getArticles() {
		return articles;
	}

	public void setArticles(Integer articles) {
		this.articles = articles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
