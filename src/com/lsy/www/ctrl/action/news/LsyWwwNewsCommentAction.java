/**
 * 
 */
package com.lsy.www.ctrl.action.news;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.kit.word.StringHelper;
import com.lsy.util.SystemConstant;
import com.lsy.www.biz.news.LsyWwwNewsCommentBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.news.KpkpWwwNewsCommentForm;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.news.KpkpWwwNewsCommentView;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Description:文章评论
 *
 * @version 1.0 2016年4月27日
 * @author LSY
 */
@Controller(value = "lsyWwwNewsCommentAction")
@Scope(value = "prototype")
public class LsyWwwNewsCommentAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwNewsCommentForm> {

	private static final long serialVersionUID = 1L;

	@Resource(name = "lsyWwwNewsCommentBiz")
	private LsyWwwNewsCommentBiz lsyWwwNewsCommentBiz;

	private KpkpWwwNewsCommentView commentView;
	private LsyWwwPaginView<KpkpWwwNewsCommentView> commentPagin;

	public KpkpWwwNewsCommentView getCommentView() {
		return commentView;
	}

	public LsyWwwPaginView<KpkpWwwNewsCommentView> getCommentPagin() {
		return commentPagin;
	}

	private KpkpWwwNewsCommentForm model = new KpkpWwwNewsCommentForm();

	@Override
	public KpkpWwwNewsCommentForm getModel() {
		return this.model;
	}

	@Override
	public String getActionDealMsg() {
		return super.getActionDealMsg();
	}

	/**
	 * 新建
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String create() throws ActionException {
		try {
			this.model.setUserId(this.getUserSession().getUserId());
			this.model.setContent(StringHelper.sql2Text(this.model.getContent()));
			this.commentView = this.lsyWwwNewsCommentBiz.create(this.model.getUserId(), this.model.getReId(),
					this.model.getNewsId(), this.model.getContent());
			return SUCCESS;
		} catch (BizException se) {
			log.error("create error", se);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("create error", e);
			throw new ActionException(this.getText("action.biz.error"));
		}
	}

	/**
	 * 新建
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String delete() throws ActionException {
		try {
			if (this.lsyWwwNewsCommentBiz.delete(this.model.getCommentId())) {
				this.actionDealMsg = SystemConstant.ACTION_RESULT_SUCCESS;
			} else {
				this.actionDealMsg = SystemConstant.ACTION_RESULT_FAILURE;
			}
			return SUCCESS;
		} catch (BizException se) {
			log.error("delete error", se);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("delete error", e);
			throw new ActionException(this.getText("action.biz.error"));
		}
	}

	/**
	 * 分页
	 * 
	 * @return
	 * @throws ActionException
	 */
	public String pagin() throws ActionException {
		try {
			this.commentPagin = this.lsyWwwNewsCommentBiz.getPagin(this.model.getNewsId(), this.model.getCurPage(), 3);
			return SUCCESS;
		} catch (BizException se) {
			log.error("pagin error", se);
			throw new ActionException(this.getText("action.biz.error"));
		} catch (Exception e) {
			log.error("pagin error", e);
			throw new ActionException(this.getText("action.biz.error"));
		}
	}
}
