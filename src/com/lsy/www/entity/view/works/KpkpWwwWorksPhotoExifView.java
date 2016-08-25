/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.lsy.www.entity.view.works;

/**
 * Description:作品照片EXIF信息视图
 * 
 * @version 1.0 2015年12月3日
 * @author Wu guang jing
 */
public class KpkpWwwWorksPhotoExifView {

	private Integer photoId;
	private String make;
	private String model;
	private String focalLength;
	private String aperture;
	private String shutterSpeed;
	private String iso;
	private String ev;
	private String lens;
	private String latitude;
	private String longitude;
	private String shootTimeDes;

	public Integer getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	public String getAperture() {
		return aperture;
	}

	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	public String getShutterSpeed() {
		return shutterSpeed;
	}

	public void setShutterSpeed(String shutterSpeed) {
		this.shutterSpeed = shutterSpeed;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getEv() {
		return ev;
	}

	public void setEv(String ev) {
		this.ev = ev;
	}

	public String getLens() {
		return lens;
	}

	public void setLens(String lens) {
		this.lens = lens;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getShootTimeDes() {
		return shootTimeDes;
	}

	public void setShootTimeDes(String shootTimeDes) {
		this.shootTimeDes = shootTimeDes;
	}

}
