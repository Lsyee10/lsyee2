/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Description:用户短信校验
 * 
 * @version 1.0 2015年11月26日
 * @author Wu guang jing
 */
public class KpkpWwwUserAuthSms implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer smsId;
	private Integer userId;
	private String cellphone;
	private String content;
	private String reqNum;
	private String seqNum;
	private String authCode;
	private Integer words;
	private Integer branches;
	private String sign;
	private Integer useFlag;
	private Integer checkFlag;
	private Integer receiptFlag;
	private Timestamp receiptTime;
	private Timestamp sendTime;
	private Integer checkTimes;

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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public Integer getBranches() {
		return branches;
	}

	public void setBranches(Integer branches) {
		this.branches = branches;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public Timestamp getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Timestamp receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getCheckTimes() {
		return checkTimes;
	}

	public void setCheckTimes(Integer checkTimes) {
		this.checkTimes = checkTimes;
	}
}