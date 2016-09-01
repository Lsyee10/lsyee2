/**
 * Project : lsy
 * Copyright (c) Hang Zhou Daily Press Group.
 * All rights reserved.
 */
package com.lsy.www.ctrl.action.sys;

import com.kit.exception.ActionException;
import com.kit.exception.BizException;
import com.lsy.www.biz.works.LsyWwwWorksTopicBiz;
import com.lsy.www.ctrl.action.LsyWwwBaseAction;
import com.lsy.www.entity.form.sys.KpkpWwwSysHomeForm;
import com.lsy.www.entity.view.works.KpkpWwwWorksTopicView;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:首页动作控制
 *
 * @author Wu guang jing
 * @version 1.0 2015年12月15日
 */
@Controller("lsyWwwSysHomeAction")
@Scope("prototype")
public class LsyWwwSysHomeAction extends LsyWwwBaseAction implements ModelDriven<KpkpWwwSysHomeForm> {
    private static final long serialVersionUID = 1L;

    private KpkpWwwSysHomeForm model = new KpkpWwwSysHomeForm();

    public KpkpWwwSysHomeForm getModel() {
        return model;
    }

    @Resource(name = "lsyWwwWorksTopicBiz")
    private LsyWwwWorksTopicBiz lsyWwwWorksTopicBiz;


    private List<KpkpWwwWorksTopicView> choiceTopics;
    private List<KpkpWwwWorksTopicView> newestTopics;

    public List<KpkpWwwWorksTopicView> getChoiceTopics() {
        return choiceTopics;
    }

    public List<KpkpWwwWorksTopicView> getNewestTopics() {
        return newestTopics;
    }

    /**
     * 静态模式
     *
     * @return
     * @throws ActionException
     */
    public String staticize() throws ActionException {
        try {
            this.choiceTopics = this.lsyWwwWorksTopicBiz.getChoiceTopics(10);
            this.newestTopics = this.lsyWwwWorksTopicBiz.getNewestTopics(10);
            return SUCCESS;
        } catch (BizException be) {
            log.error("staticize error", be);
            throw new ActionException(this.getText("action.biz.error"));
        } catch (Exception e) {
            log.error("staticize error", e);
            throw new ActionException(this.getText("action.ctrl.error"));
        }
    }
}
