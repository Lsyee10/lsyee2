/**
 * 
 */
package com.lsy.www.ctrl.action.news;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.kit.word.StringHelper;
import com.lsy.www.biz.news.LsyWwwNewsArticleBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.news.KpkpWwwNewsArticleForm;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsArticleView;
import com.lsy.www.entity.view.news.KpkpWwwNewsColumnView;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Description:资讯文章
 *
 * @version 1.0 2016年4月20日
 * @author LSY
 */
@Controller(value = "lsyWwwNewsArticleAction")
@Scope(value = "prototype")
public class LsyWwwNewsArticeAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwNewsArticleForm> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "lsyWwwNewsArticleBiz")
	private LsyWwwNewsArticleBiz lsyWwwNewsArticleBiz;

	private String title;
	private KpkpWwwNewsArticleView articleView;
	List<KpkpWwwNewsArticleView> relateList;
	private List<KpkpWwwNewsColumnView> columnList;
	private List<KpkpWwwNewsArticleView> topArticleList;
	private LsyWwwPaginView<KpkpWwwNewsArticleView> articlePagin;

	public List<KpkpWwwNewsArticleView> getRelateList() {
		return relateList;
	}

	public String getTitle() {
		return title;
	}

	public List<KpkpWwwNewsColumnView> getColumnList() {
		return columnList;
	}

	public List<KpkpWwwNewsArticleView> getTopArticleList() {
		return topArticleList;
	}

	public LsyWwwPaginView<KpkpWwwNewsArticleView> getArticlePagin() {
		return articlePagin;
	}

	public KpkpWwwNewsArticleView getArticleView() {
		return articleView;
	}

	private KpkpWwwNewsArticleForm model = new KpkpWwwNewsArticleForm();

	@Override
	public KpkpWwwNewsArticleForm getModel() {
		return this.model;
	}

	/**
	 * 资讯分页
	 * 
	 * @return
	 */
	public String pagin() throws ActionException {
		KpkpWwwNewsColumnView columnView = null;
		try {
			// 如果是标签文章
			if (!StringHelper.ifNull(this.model.getTag())) {
				// 设置标题
				this.title = "有关" + "“" + this.model.getTag() + "”" + "的文章";

				// 获取标签文章分页
				this.articlePagin = this.lsyWwwNewsArticleBiz.getTagPagin(this.model.getTag(), this.model.getCurPage(),
						10);
			}
			// 如果是栏目文章
			else if (this.model.getColumnId() != null) {
				// 设置标题
				columnView = this.lsyWwwNewsArticleBiz.getColumnView(this.model.getColumnId());
				this.title = columnView.getName();

				// 获取栏目文章分页
				this.articlePagin = this.lsyWwwNewsArticleBiz.getColumnPagin(this.model.getColumnId(),
						this.model.getCurPage(), 10);
			} else {
				// 设置标题
				this.title = "全部文章";

				// 获取所有文章分页
				this.articlePagin = this.lsyWwwNewsArticleBiz.getAllPagin(1, 10);
			}

			// 右侧栏目列表
			this.columnList = this.lsyWwwNewsArticleBiz.getColumnList(10);

			// 猜你喜欢
			this.topArticleList = this.lsyWwwNewsArticleBiz.getTopList(10);

			return SUCCESS;
		} catch (BizException se) {
			log.error("pagin error", se);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("pagin error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		} finally {
			columnView = null;
		}
	}

	/**
	 * 文章详情
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String detail() throws ActionException {
		try {
			// 获取文章内容
			this.articleView = this.lsyWwwNewsArticleBiz.getDetail(this.model.getNewsId());

			// 如果文章存在
			if (null != this.articleView) {
				// 获取右侧栏目列表
				this.columnList = this.lsyWwwNewsArticleBiz.getColumnList(10);

				// 猜你喜欢
				this.topArticleList = this.lsyWwwNewsArticleBiz.getTopList(10);

				// 标签相关文章列表
				this.relateList = this.lsyWwwNewsArticleBiz.getRelateList(this.model.getNewsId(), 3);
			}
			return SUCCESS;
		} catch (BizException e) {
			log.error("detail error", e);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("detail error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		}
	}

	/**
	 *
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String doc() throws ActionException {
		try {
			// 获取文章内容
			this.articleView = this.lsyWwwNewsArticleBiz.getDetail(this.model.getNewsId());

			// 如果文章存在
			if (null != this.articleView) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (BizException se) {
			log.error("doc error", se);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("doc error", e);
			throw new ActionException(this.getText("action.ctrl.error"));
		}
	}

}
