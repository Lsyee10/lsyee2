/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.cond.user;

import com.lsy.util.SystemConstant;
import com.lsy.www.entity.cond.KpkpWwwBaseCond;

/**
 * Description:用户短信校验查询条件
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserAuthSmsCond extends KpkpWwwBaseCond {

	private Integer smsId;
	private Integer userId;
	private Integer userIdNeq;
	private String cellphone;
	private String reqNum;
	private String seqNum;
	private String authCode;
	private Integer useFlag;
	private Integer checkFlag;
	private Integer receiptFlag;
	private String sendTimeSt;
	private String sendTimeEd;

	public Integer getSmsId() {
		return smsId;
	}

	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserIdNeq() {
		return userIdNeq;
	}

	public void setUserIdNeq(Integer userIdNeq) {
		this.userIdNeq = userIdNeq;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getReqNum() {
		return reqNum;
	}

	public void setReqNum(String reqNum) {
		this.reqNum = reqNum;
	}

	public String getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(String seqNum) {
		this.seqNum = seqNum;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public Integer getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(Integer useFlag) {
		this.useFlag = useFlag;
	}

	public Integer getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(Integer checkFlag) {
		this.checkFlag = checkFlag;
	}

	public Integer getReceiptFlag() {
		return receiptFlag;
	}

	public void setReceiptFlag(Integer receiptFlag) {
		this.receiptFlag = receiptFlag;
	}

	public String getSendTimeSt() {
		if ("".equals(this.sendTimeSt) || null == this.sendTimeSt) {
			return null;
		} else {
			return this.sendTimeSt + SystemConstant.QUERY_TIME_START;
		}
	}

	public void setSendTimeSt(String sendTimeSt) {
		this.sendTimeSt = sendTimeSt;
	}

	public String getSendTimeEd() {
		if ("".equals(this.sendTimeEd) || null == this.sendTimeEd) {
			return null;
		} else {
			return this.sendTimeEd + SystemConstant.QUERY_TIME_END;
		}
	}

	public void setSendTimeEd(String sendTimeEd) {

		this.sendTimeEd = sendTimeEd;
	}
}