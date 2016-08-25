/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

/**
 * Description:作品照片上传视图
 * 
 * @version 1.0 2015年11月27日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoUploadView {

	private Integer photoId = 0;
	private String host;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String intro;
	private Integer coverFlag;
	private String json;
	private KpkpWwwWorksPhotoExifView exif;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getCoverFlag() {
		return coverFlag;
	}

	public void setCoverFlag(Integer coverFlag) {
		this.coverFlag = coverFlag;
	}

	public KpkpWwwWorksPhotoExifView getExif() {
		return exif;
	}

	public void setExif(KpkpWwwWorksPhotoExifView exif) {
		this.exif = exif;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

}
