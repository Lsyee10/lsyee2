/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.news;

import java.io.Serializable;

/**
 * Description:资讯文章
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsArticle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer newsId;
	private String content;

	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
