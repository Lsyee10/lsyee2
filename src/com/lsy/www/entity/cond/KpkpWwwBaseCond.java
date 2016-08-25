/**
 * Project : toolkit
 * Copyright (c) Wu Guang Jing. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond;

import com.lsy.util.SystemConstant;


/**
 * Description:条件基础类
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 * 
 */
public class KpkpWwwBaseCond {

	private Integer curPage;
	private Integer pageRows;
	private Integer totalRows;
	private Integer firstResult;
	private Integer maxResults;
	private String orderParam;
	private String statsParam;
	private String groupParam;
	private String updateParam;
	private String addTimeSt;
	private String addTimeEd;
	private String modTimeSt;
	private String modTimeEd;

	public Integer getCurPage() {
		if (null == curPage) {
			return SystemConstant.PAGIN_INIT_CUR_PAGE;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageRows() {
		if (null == pageRows || pageRows == 0) {
			return SystemConstant.PAGIN_INIT_PAGE_ROWS;
		}
		return pageRows;
	}

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public String getOrderParam() {
		return orderParam;
	}

	public void setOrderParam(String orderParam) {
		this.orderParam = orderParam;
	}

	public String getStatsParam() {
		return statsParam;
	}

	public void setStatsParam(String statsParam) {
		this.statsParam = statsParam;
	}

	public String getGroupParam() {
		return groupParam;
	}

	public void setGroupParam(String groupParam) {
		this.groupParam = groupParam;
	}

	public String getAddTimeSt() {
		if ("".equals(addTimeSt) || null == addTimeSt) {
			return null;
		} else {
			return addTimeSt + SystemConstant.QUERY_TIME_START;
		}
	}

	public void setAddTimeSt(String addTimeSt) {
		this.addTimeSt = addTimeSt;
	}

	public String getAddTimeEd() {
		if ("".equals(addTimeEd) || null == addTimeEd) {
			return null;
		} else {
			return addTimeEd + SystemConstant.QUERY_TIME_END;
		}
	}

	public void setAddTimeEd(String addTimeEd) {
		this.addTimeEd = addTimeEd;
	}

	public String getUpdateParam() {
		return updateParam;
	}

	public void setUpdateParam(String updateParam) {
		this.updateParam = updateParam;
	}

	public String getModTimeSt() {
		if ("".equals(modTimeSt) || null == modTimeSt) {
			return null;
		} else {
			return modTimeSt + SystemConstant.QUERY_TIME_START;
		}
	}

	public void setModTimeSt(String modTimeSt) {
		this.modTimeSt = modTimeSt;
	}

	public String getModTimeEd() {
		if ("".equals(modTimeEd) || null == modTimeEd) {
			return null;
		} else {
			return modTimeEd + SystemConstant.QUERY_TIME_END;
		}
	}

	public void setModTimeEd(String modTimeEd) {
		this.modTimeEd = modTimeEd;
	}

}
