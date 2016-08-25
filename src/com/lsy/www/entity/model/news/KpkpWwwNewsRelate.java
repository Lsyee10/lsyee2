/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.model.news;

import java.io.Serializable;

/**
 * Description:资讯相关阅读
 * 
 * @version 1.0 2015年11月25日
 * @author Wu guang jing
 */
public class KpkpWwwNewsRelate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer relateId;
	private Integer masterId;
	private Integer slaveId;

	public Integer getRelateId() {
		return relateId;
	}

	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Integer getSlaveId() {
		return slaveId;
	}

	public void setSlaveId(Integer slaveId) {
		this.slaveId = slaveId;
	}

}
