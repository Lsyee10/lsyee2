/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.form.works;

import java.io.File;
import java.sql.Date;

import com.lsy.www.entity.form.KpkpWwwBaseForm;

/**
 * Description:照片表单
 * 
 * @version 1.0 2015年12月15日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoForm extends KpkpWwwBaseForm {

	private Integer photoId;
	private String tagName;
	private String awardPrize;
	private String starIntro;
	private Date starDate;
	private File image;
	private String mode;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getAwardPrize() {
		return awardPrize;
	}

	public void setAwardPrize(String awardPrize) {
		this.awardPrize = awardPrize;
	}

	public String getStarIntro() {
		return starIntro;
	}

	public void setStarIntro(String starIntro) {
		this.starIntro = starIntro;
	}

	public Date getStarDate() {
		return starDate;
	}

	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
