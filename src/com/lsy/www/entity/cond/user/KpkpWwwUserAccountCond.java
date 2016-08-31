/**
 * Project : kpkp
 * Copyright (c) Wu Guang Jing.
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户账号条件
 *
 * @author Wu guang jing
 * @version 1.0 2015-11-23
 */
public class KpkpWwwUserAccountCond extends KpkpWwwBaseCond {

    private Integer userId;
    private String nickname;
    private String nicknameLk;
    private String password;
    private String cellphone;
    private String email;
    private String uneqEmail;
    private String qq;
    private String weibo;
    private String wechat;
    private String wechatOpenId;
    private String webSessionId;
    private String appTokenId;
    private Integer topFlag;
    private Integer stateFlag;
    private Integer loginFlag;
    private Integer typeFlag;
    private String loginIp;
    private Integer recycleFlag;
    private String regTimeSt;
    private String regTimeEd;

    public String getUneqEmail() {
        return uneqEmail;
    }

    public void setUneqEmail(String uneqEmail) {
        this.uneqEmail = uneqEmail;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRegTimeSt() {
        return regTimeSt;
    }

    public void setRegTimeSt(String regTimeSt) {
        this.regTimeSt = regTimeSt;
    }

    public String getRegTimeEd() {
        return regTimeEd;
    }

    public void setRegTimeEd(String regTimeEd) {
        this.regTimeEd = regTimeEd;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
    }

    public String getWebSessionId() {
        return webSessionId;
    }

    public void setWebSessionId(String webSessionId) {
        this.webSessionId = webSessionId;
    }

    public String getAppTokenId() {
        return appTokenId;
    }

    public void setAppTokenId(String appTokenId) {
        this.appTokenId = appTokenId;
    }

    public Integer getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(Integer topFlag) {
        this.topFlag = topFlag;
    }

    public Integer getStateFlag() {
        return stateFlag;
    }

    public void setStateFlag(Integer stateFlag) {
        this.stateFlag = stateFlag;
    }

    public Integer getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(Integer loginFlag) {
        this.loginFlag = loginFlag;
    }

    public Integer getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(Integer typeFlag) {
        this.typeFlag = typeFlag;
    }

    public Integer getRecycleFlag() {
        return recycleFlag;
    }

    public void setRecycleFlag(Integer recycleFlag) {
        this.recycleFlag = recycleFlag;
    }

    public String getNicknameLk() {
        return nicknameLk;
    }

    public void setNicknameLk(String nicknameLk) {
        this.nicknameLk = nicknameLk;
    }
}
