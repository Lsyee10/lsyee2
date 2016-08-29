/**
 *
 */
package com.lsy.www.ctrl.action.works;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.kit.word.StringHelper;
import com.lsy.util.SpringBeanUtils;
import com.lsy.util.SystemConstant;
import com.lsy.www.biz.user.LsyWwwUserAccountBiz;
import com.lsy.www.biz.works.LsyWwwWorksTopicBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.works.KpkpWwwWorksTopicForm;
import com.lsy.www.entity.view.LsyWwwPaginView;
import com.lsy.www.entity.view.user.KpkpWwwUserProfileView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicUploadView;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicView;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Description:活动主题动作
 *
 * @author LSY
 * @version 1.0 2016年5月19日
 */
@Controller("lsyWwwWorksTopicAction")
@Scope("prototype")
public class LsyWwwWorksTopicAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwWorksTopicForm> {

    private static final long serialVersionUID = 1L;
    private KpkpWwwWorksTopicForm model = new KpkpWwwWorksTopicForm();

    @Override
    public KpkpWwwWorksTopicForm getModel() {
        return this.model;
    }

    @Resource(name = "lsyWwwWorksTopicBiz")
    private LsyWwwWorksTopicBiz lsyWwwWorksTopicBiz;

    @Resource(name = "lsyWwwUserAccountBiz")
    private LsyWwwUserAccountBiz lsyWwwUserAccountBiz;

    private KpkpWwwWorksTopicView topicView;
    private KpkpWwwWorksTopicUploadView uploadeView;
    private LsyWwwPaginView<KpkpWwwWorksTopicView> topicPagin;

    public KpkpWwwWorksTopicView getTopicView() {
        return topicView;
    }

    public KpkpWwwWorksTopicUploadView getUploadeView() {
        return uploadeView;
    }

    public LsyWwwPaginView<KpkpWwwWorksTopicView> getTopicPagin() {
        return topicPagin;
    }

    /**
     * 准备新建
     *
     * @return
     * @throws ActionException
     */
    public String prepCreate() throws ActionException {
        try {

            return SUCCESS;
        } catch (Exception ec) {
            log.error("prepCreate err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 执行新建
     *
     * @return
     * @throws ActionException
     */
    public String dealCreate() throws ActionException {
        try {
            // 设置用户id
            this.model.setUserId(this.getUserSession().getUserId());

            // 如果添加成功
            if (this.lsyWwwWorksTopicBiz.create(model)) {
                return SUCCESS;
            } else {
                return INPUT;
            }

        } catch (BizException e) {
            log.error("prepCreate err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("prepCreate err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 准备修改
     *
     * @return
     * @throws ActionException
     */
    public String prepModify() throws ActionException {
        try {
            // 初始化表单
            if (null != this.model.getTopicId()) {
                // 获取已上传组图
                this.uploadeView = this.lsyWwwWorksTopicBiz.getUploadView(this.model.getTopicId());

                // 如果视图存在
                if (null != uploadeView) {
                    SpringBeanUtils.copyProperties(uploadeView, this.model);
                }
                return SUCCESS;
            }

            return ERROR;
        } catch (BizException e) {
            log.error("prepModify err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("prepModify err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 执行修改
     *
     * @return
     * @throws ActionException
     */
    public String dealModify() throws ActionException {
        try {
            // 如果组照id存在且是当前用户在修改
            if (null != this.model.getTopicId()) {
                this.model.setUserId(this.getUserSession().getUserId());

                // 如果修改成功
                if (this.lsyWwwWorksTopicBiz.modify(model)) {
                    return SUCCESS;
                } else {
                    return INPUT;
                }
            }

            return ERROR;
        } catch (BizException e) {
            log.error("dealModify err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("dealModify err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 回收
     *
     * @return
     * @throws ActionException
     */
    public String recycle() throws ActionException {
        try {
            if (this.lsyWwwWorksTopicBiz.recycle(this.getUserSession().getUserId(), this.model.getTopicId())) {
                this.actionDealMsg = SystemConstant.ACTION_RESULT_SUCCESS;
            } else {
                this.actionDealMsg = SystemConstant.ACTION_RESULT_FAILURE;
            }

            return ERROR;
        } catch (BizException e) {
            log.error("recycle err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("recycle err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 获取详情
     *
     * @return
     * @throws ActionException
     */
    public String detail() throws ActionException {
        try {
            // 如果用户会话不存在
            if (null == this.getUserSession()) {
                this.topicView = this.lsyWwwWorksTopicBiz.detail(this.model.getTopicId());
            } else {
                this.topicView = this.lsyWwwWorksTopicBiz.detail(this.model.getTopicId(), this.getUserSession()
                        .getUserId(), this.getUserSession().getTypeFlag());
            }

            return SUCCESS;
        } catch (BizException e) {
            log.error("detail err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("detail err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 我关注过的摄影师的组照
     *
     * @return
     * @throws ActionException
     */
    public String myFocusedTopics() throws ActionException {
        try {
            // 获取用户关注摄影师照片列表
            this.topicPagin = this.lsyWwwWorksTopicBiz.getUserFocusedTopic(this.getUserSession().getUserId(),
                    this.model.getCurPage(), this.model.getPageRows());

            return SUCCESS;
        } catch (BizException e) {
            log.error("myFocusedTopics err", e);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception ec) {
            log.error("myFocusedTopics err", ec);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 获取我的最新组照
     *
     * @return
     * @throws ActionException
     */
    public String myNewestTopics() throws ActionException {
        try {
            this.topicPagin = this.lsyWwwWorksTopicBiz.getUserNewestTopics(this.getUserSession().getUserId(),
                    this.model.getCurPage(), 16);
            return SUCCESS;
        } catch (BizException se) {
            log.error("myNewestTopics error", se);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("myNewestTopics error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 获取TA最新组照分页
     *
     * @return
     * @throws ActionException
     */
    public String hisNewestTopics() throws ActionException {
        KpkpWwwUserProfileView profileView = null;
        try {
            // 如果访问他人的主页的作品
            if (null != this.model.getUserId() && this.model.getUserId() > 0) {
                // 获取用户组照列表
                this.topicPagin = this.lsyWwwWorksTopicBiz.getUserNewestTopics(this.model.getUserId(),
                        this.model.getCurPage(), 12);
                return SUCCESS;
            } else if (!StringHelper.ifNull(this.model.getNickname())) {

                // 获取用户资料
                profileView = this.lsyWwwUserAccountBiz.profile(this.model.getNickname());

                // 如果用户资料存在
                if (null != profileView) {
                    // 设置用户id
                    this.model.setUserId(profileView.getUserId());

                    // 获取用户组照列表
                    this.topicPagin = this.lsyWwwWorksTopicBiz.getUserNewestTopics(this.model.getUserId(),
                            this.model.getCurPage(), 12);
                    return SUCCESS;
                } else {
                    return ERROR;
                }
            } else {
                return ERROR;
            }
        } catch (BizException se) {
            log.error("hisNewestTopics error", se);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("hisNewestTopics error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        } finally {
            profileView = null;
        }
    }

    /**
     * 最新组图
     *
     * @return
     * @throws ActionException
     */
    public String newestTopics() throws ActionException {
        try {
            this.topicPagin = this.lsyWwwWorksTopicBiz.getNewestTopics(this.model.getCurPage(), 36);
            return SUCCESS;
        } catch (BizException se) {
            log.error("newestTopics error", se);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("newestTopics error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

    /**
     * 推荐组图
     *
     * @return
     * @throws ActionException
     */
    public String topTopics() throws ActionException {
        try {
            this.topicPagin = this.lsyWwwWorksTopicBiz.getTopTopics(this.model.getCurPage(), 36);
            return SUCCESS;
        } catch (BizException se) {
            log.error("topTopics error", se);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("topTopics error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }

}
