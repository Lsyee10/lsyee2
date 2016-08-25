/**
 * 
 */
package com.lsy.www.biz.works;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kit.exception.BizException;
import com.kit.media.image.ImageAttr;
import com.kit.media.image.ImageHelper;
import com.kit.servlet.ContextHelper;
import com.kit.word.JodaTimeHelper;
import com.lsy.util.SystemConstant;
import com.lsy.www.biz.LsyWwwBaseBizImpl;
import com.lsy.www.dao.works.KpkpWwwWorksPhotoDao;
import com.lsy.www.entity.view.works.KpkpWwwWorksPhotoUploadView;

/**
 * Description:
 *
 * @version 1.0 2016年5月20日
 * @author LSY
 */
@Service("lsyWwwWorksPhotoBiz")
public class LsyWwwWorksPhotoBizImpl extends LsyWwwBaseBizImpl implements LsyWwwWorksPhotoBiz {

	@Resource(name = "kpkpWwwWorksPhotoDao")
	private KpkpWwwWorksPhotoDao kpkpWwwWorksPhotoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.lsy.www.biz.works.LsyWwwWorksPhotoBiz#upload(java.io.File)
	 */
	@Override
	public KpkpWwwWorksPhotoUploadView upload(File file) throws BizException {
		File image = null;
		Integer ori = null;
		Integer zoom = null;
		String cusDir = null;
		String cutName = null;
		ImageAttr img1 = null;
		ImageAttr img2 = null;
		ImageAttr img3 = null;
		ImageAttr img4 = null;
		KpkpWwwWorksPhotoUploadView uoloadeView = null;
		try {
			// 定义文件日期
			cusDir = JodaTimeHelper.getYear();

			// 建立原图
			img1 = ImageHelper.getInstance().create(file, ContextHelper.getRealPath(SystemConstant.UPLOAD_PATH_WORKS),
					SystemConstant.UPLOAD_PATH_WORKS, cusDir, UUID.randomUUID().toString(), ".jpg", null);

			// 构建原图对象
			image = new File(ContextHelper.getRealPath(SystemConstant.UPLOAD_PATH_NEWS) + File.separator
					+ img1.getName());

			// 建立大图（1080p）
			zoom = img1.getHeight() > img1.getWidth() ? img1.getHeight() : img1.getWidth();
			img2 = ImageHelper.getInstance().create(file, ContextHelper.getRealPath(SystemConstant.UPLOAD_PATH_NEWS),
					SystemConstant.UPLOAD_PATH_NEWS, cusDir, UUID.randomUUID().toString(), ".jpg",
					zoom > 1080 ? 1080 : zoom);

			// 开始构建方图350x350
			// 开始建立350缩略图
			img3 = ImageHelper.getInstance().resize(image, ContextHelper.getRealPath(SystemConstant.UPLOAD_PATH_WORKS),
					SystemConstant.UPLOAD_PATH_WORKS, cusDir, UUID.randomUUID().toString(), ".jpg", 350);

			// 生成350才切图
			cutName = ImageHelper.getInstance().cut(SystemConstant.UPLOAD_PATH_WORKS + img3.getName(), 350, 350);

			// 删除350缩略图

			// 记录裁切图信息

			return null;
		} catch (Exception e) {
			log.error("upload error", e);
			throw new BizException("upload failure");
		} finally {
			image = null;
			ori = null;
			zoom = null;
			cusDir = null;
			cutName = null;
			img1 = null;
			img2 = null;
			img3 = null;
			img4 = null;
			uoloadeView = null;
		}
	}
}
