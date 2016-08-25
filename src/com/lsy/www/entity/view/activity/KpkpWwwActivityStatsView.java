/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.activity;

/**
 * Description:活动统计视图
 * 
 * @version 1.0 2015年12月16日
 * @author Wu guang jing
 */
public class KpkpWwwActivityStatsView {

	private Integer ingNum;// 进行中
	private Integer endNum;// 结束
	@SuppressWarnings("unused")
	private Integer allNum;

	public Integer getIngNum() {
		return ingNum;
	}

	public void setIngNum(Integer ingNum) {
		this.ingNum = ingNum;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public Integer getAllNum() {
		return this.endNum + this.ingNum;
	}

	public void setAllNum(Integer allNum) {
		this.allNum = allNum;
	}

}
