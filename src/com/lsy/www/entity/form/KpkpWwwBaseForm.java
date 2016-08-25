/**
 * Project:dsj
 * Copyright (c) Wu Guang Jing
 * All rights reserved
 */
package com.lsy.www.entity.form;

import com.lsy.util.SystemConstant;

/**
 * Class Description:基础表单类
 * 
 * @version 1.0 2014-8-15
 * @author Wu guang jing
 */
public class KpkpWwwBaseForm {

	private Integer curPage;
	private Integer pageRows;
	private String orderParam;
	private String addTimeSt;
	private String addTimeEd;
	private String menuHandle;
	private String scope;

	public String getMenuHandle() {
		return menuHandle;
	}

	public void setMenuHandle(String menuHandle) {
		this.menuHandle = menuHandle;
	}

	public Integer getCurPage() {
		if (null == curPage || "".equals(curPage)) {
			return SystemConstant.PAGIN_INIT_CUR_PAGE;
		}
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageRows() {
		return pageRows;
	}

	public void setPageRows(Integer pageRows) {
		this.pageRows = pageRows;
	}

	public String getOrderParam() {
		return orderParam;
	}

	public void setOrderParam(String orderParam) {
		this.orderParam = orderParam;
	}

	public String getAddTimeSt() {
		return addTimeSt;
	}

	public void setAddTimeSt(String addTimeSt) {
		this.addTimeSt = addTimeSt;
	}

	public String getAddTimeEd() {
		return addTimeEd;
	}

	public void setAddTimeEd(String addTimeEd) {
		this.addTimeEd = addTimeEd;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
