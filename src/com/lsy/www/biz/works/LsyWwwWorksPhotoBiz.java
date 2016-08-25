/**
 * 
 */
package com.lsy.www.biz.works;

import java.io.File;

import com.kit.exception.BizException;
import com.lsy.www.entity.view.works.KpkpWwwWorksPhotoUploadView;

/**
 * Description:相片业务
 *
 * @version 1.0 2016年5月20日
 * @author LSY
 */
public interface LsyWwwWorksPhotoBiz {

	/**
	 * 上传照片
	 * 
	 * @param image
	 * @return
	 * @throws BizException
	 */
	public KpkpWwwWorksPhotoUploadView upload(File image) throws BizException;
}
