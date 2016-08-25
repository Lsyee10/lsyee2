/**
 * 
 */
package com.lsy.www.entity.view;

import java.io.Serializable;
import java.util.List;

import com.lsy.util.SystemConstant;

/**
 * Description:基础返回视图
 * 
 * @author LSY
 * 
 */
public class LsyWwwPaginView<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String jump;// 翻页标示
	private Integer curPage;// 当前页
	private Integer pageRows;// 每页结果
	private Integer totalRows;// 查询结果总数
	private Integer totalPages;// 查询结果页数
	private Integer firstResult;// 获取当前页信息时，数据库游标所指向的开始行
	private List<T> curPageList;// 当前页记录集合列表

	/**
	 * 初始化构造器
	 */
	public LsyWwwPaginView() {
		this.setTotalRows(0);
		this.totalPages = 0;
		this.firstResult = 0;
		this.setCurPageList(null);
		this.jump = SystemConstant.PAGIN_JUMP_FIRST;
		this.curPage = SystemConstant.PAGIN_INIT_CUR_PAGE;
		this.setPageRows(SystemConstant.PAGIN_INIT_PAGE_ROWS);
	}

	/**
	 * 初始化构造器
	 * 
	 * @param curPage
	 * @param totalRows
	 * @param jump
	 */
	public LsyWwwPaginView(Integer curPage, Integer totalRows, String jump) {
		this.setTotalRows(totalRows);
		this.totalPages = 0;
		this.firstResult = 0;
		this.setCurPageList(null);
		this.jump = jump;
		this.curPage = curPage;
		this.setPageRows(SystemConstant.PAGIN_INIT_PAGE_ROWS);
		this.changeCurrentPage();
	}

	/**
	 * 初始化构造器
	 * 
	 * @param curPage
	 * @param pageRows
	 * @param totalRows
	 * @param jump
	 */
	public LsyWwwPaginView(Integer curPage, Integer pageRows, Integer totalRows, String jump) {
		this.setTotalRows(totalRows);
		this.totalPages = 0;
		this.firstResult = 0;
		this.setCurPageList(null);
		this.jump = jump;
		this.curPage = curPage;
		this.setPageRows(pageRows);
		this.changeCurrentPage();
	}

	/**
	 * @param curPage
	 * @param pageRows
	 * @param totalRows
	 */
	public LsyWwwPaginView(Integer curPage, Integer pageRows, Integer totalRows) {
		this.setTotalRows(totalRows);
		this.totalPages = 0;
		this.firstResult = 0;
		this.setCurPageList(null);
		this.curPage = curPage;
		this.setPageRows(pageRows);
		this.jump = SystemConstant.PAGIN_JUMP_FIRST;
	}

	/**
	 * @return
	 */
	public Integer getCurPage() {
		if (totalPages.intValue() > 0) {
			if (this.curPage.intValue() > this.totalPages.intValue()) {
				this.curPage = this.totalPages;
			}
		}
		return curPage;
	}

	/**
	 * 页面跳转
	 */
	public void changeCurrentPage() {
		// 如果为当前页
		if (this.jump.equals(SystemConstant.PAGIN_JUMP_FIRST)) {
			this.curPage = 1;
		}
		// 跳转到前一页
		else if (this.jump.equals(SystemConstant.PAGIN_JUMP_PREV)) {
			if (this.curPage > 1) {
				this.curPage -= 1;
			}
		}
		// 跳转到后一页
		else if (this.jump.equals(SystemConstant.PAGIN_JUMP_NEXT)) {
			if (this.curPage < this.totalPages) {
				this.curPage += 1;
			}
		}
		// 跳转到最后页
		else if (this.jump.equals(SystemConstant.PAGIN_JUMP_LAST)) {
			this.curPage = this.totalPages;
		}
		// 跳转到指定页
		else if (this.jump.equals(SystemConstant.PAGIN_JUMP_POINT)) {
			if (this.curPage < 1) {
				this.curPage = 1;
			} else if (this.curPage > this.totalPages) {
				this.curPage = this.totalPages;
			}
		}
	}

	public List<T> getCurPageList() {
		return curPageList;
	}

	public void setCurPageList(List<T> curPageList) {
		this.curPageList = curPageList;
	}

	public Integer getPageRows() {
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

	public Integer getTotalPages() {
		if (this.totalRows / this.pageRows == 0) {
			this.totalPages = this.totalRows / this.pageRows;
		} else {
			this.totalPages = this.totalRows / this.pageRows + 1;
		}
		return totalPages;
	}

	public Integer getFirstResult() {
		this.firstResult = (this.curPage - 1) * this.pageRows;
		return this.firstResult;
	}

	public Integer getMaxResults() {
		return this.pageRows;
	}

}
