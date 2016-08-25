/**
 * 
 */
package com.kit.media.image;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.kit.servlet.ContextHelper;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Description:图片类
 *
 * @version 1.0 2016年4月29日
 * @author LSY
 */
public class ImageHelper {

	private ImageHelper() {

	}

	private static class CreateInstance {
		private static ImageHelper instance = new ImageHelper();
	}

	public static ImageHelper getInstance() {
		return CreateInstance.instance;
	}

	/**
	 * 检查目录存在与否
	 * 
	 * @param dir
	 * @return
	 */
	public boolean checkDir(String dir) {
		File file = null;
		try {
			file = new File(dir);

			// 如果目录存在
			if (file.exists()) {
				return true;
			} else {
				// 如果不是以分页符结尾
				if (!dir.endsWith(File.separator)) {
					dir += File.separator;
				}

				/*
				 * mkdir() 创建此抽象路径名指定的目录。 mkdirs() 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
				 */
				// 创建目录
				if (file.mkdirs()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			file = null;
		}
	}

	/**
	 * 生成无损图片
	 * 
	 * @param file
	 * @param realDir
	 * @param fixDir
	 * @param name
	 * @param type
	 * @param orinetation
	 * @return
	 */
	public ImageAttr create(File file, String realDir, String fixDir, String cusDir, String name, String type,
			Integer orinetation) {
		String path = null;
		JPEGEncodeParam param = null;
		JPEGImageEncoder encoder = null;
		BufferedImage curBufImg = null;
		BufferedImage newBufImg = null;
		FileOutputStream fos = null;
		ImageAttr fileView = null;
		try {
			// 获取文件夹m目录
			path = realDir + File.separator + cusDir;

			// 如果目录存在
			if (this.checkDir(path)) {
				// 构建图片缓冲区(加载图片)
				curBufImg = this.toBufferefImage(Toolkit.getDefaultToolkit().getImage(file.getPath()));

				// 如果照片需要旋转90度
				if (null != orinetation && orinetation.intValue() == 6) {

					// 获取图像文件
					int width = curBufImg.getWidth();
					int height = curBufImg.getHeight();

					// 构建新的图片缓冲区
					newBufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

					// 旋转照片
					for (int i = 0; i < width; i++) {
						for (int j = 0; j < height; j++) {
							newBufImg.setRGB(height - j - 1, i, curBufImg.getRGB(i, j));
						}
					}

					// 重置当前缓冲区
					curBufImg = newBufImg;
				}

				// 文件名
				name = name + "-" + curBufImg.getWidth() + "x" + curBufImg.getHeight();

				// 构建保存路径
				path = path + File.separator + name + type;
				fos = new FileOutputStream(path);
				encoder = JPEGCodec.createJPEGEncoder(fos);
				encoder.encode(curBufImg);
				fos.close();

				// 输出图片
				curBufImg.getGraphics().drawImage(
						curBufImg.getScaledInstance(curBufImg.getWidth(), curBufImg.getHeight(),
								BufferedImage.SCALE_SMOOTH), 0, 0, null);
				fos = new FileOutputStream(path);
				param = JPEGCodec.getDefaultJPEGEncodeParam(curBufImg);
				param.setQuality(1f, false);
				encoder = JPEGCodec.createJPEGEncoder(fos, param);
				encoder.encode(curBufImg);
				fos.close();

				// 构建文件视图描述
				fileView = new ImageAttr();
				fileView.setType(type);
				fileView.setName(cusDir + "/" + name + type);
				fileView.setPath(fixDir + fileView.getName());
				fileView.setSize(String.valueOf(file.length() / 1024));
				fileView.setWidth(curBufImg.getWidth());
				fileView.setHeight(curBufImg.getHeight());

				// 关闭输出流
				fos.flush();
				fos.close();
			}

			return fileView;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			path = null;
			param = null;
			encoder = null;
			curBufImg = null;
			newBufImg = null;
			fos = null;
			fileView = null;
		}

	}

	/**
	 * 生成图片（压缩）
	 * 
	 * @param file
	 * @param realDir
	 * @param fixDir
	 * @param cusDir
	 * @param name
	 * @param type
	 * @param zoom
	 * @return
	 */
	public ImageAttr create(File file, String realDir, String fixDir, String cusDir, String name, String type,
			float zoom) {
		String path = null;
		Image image = null;
		BufferedImage bufImg = null;
		FileOutputStream fos = null;
		JPEGEncodeParam param = null;
		JPEGImageEncoder encoder = null;
		ImageAttr fileView = null;
		try {
			// 获取图像
			image = ImageIO.read(file);
			// image = Toolkit.getDefaultToolkit().getImage(file.getPath());

			// 如果没有不需要缩放的图片
			if (image.getWidth(null) < zoom && image.getHeight(null) < zoom) {
				return this.create(file, realDir, fixDir, cusDir, name, type, null);
			} else {

				// 获取目录
				path = realDir + File.separator + cusDir;

				// 如果目录存在
				if (this.checkDir(path)) {

					// 构建文件视图
					fileView = new ImageAttr();

					// 构建保存路径
					float size = 0;

					// 如果宽度大于高度，重新计算图片大小
					if (image.getWidth(null) > image.getHeight(null)) {
						size = image.getWidth(null) / zoom;
					} else {
						size = image.getHeight(null) / zoom;
					}
					// 设置新的高度和宽度
					fileView.setWidth(Math.round(image.getWidth(null) / size));
					fileView.setHeight(Math.round(image.getHeight(null) / size));

					// 构建新的图片缓冲区
					bufImg = new BufferedImage(fileView.getWidth(), fileView.getHeight(), BufferedImage.TYPE_INT_RGB);

					// 输出图片
					bufImg.getGraphics().drawImage(
					// 创建此图像的缩放版本(SCALE_SMOOTH:选择图像平滑度比缩放速度具有更高优先级的图像缩放算法)
							image.getScaledInstance(fileView.getWidth(), fileView.getHeight(),
									BufferedImage.SCALE_SMOOTH), 0, 0, null);
					name = name + "-" + fileView.getWidth() + "x" + fileView.getHeight();
					path = path + File.separator + name + type;
					fos = new FileOutputStream(path);

					param = JPEGCodec.getDefaultJPEGEncodeParam(bufImg);
					param.setQuality(1f, false);
					encoder = JPEGCodec.createJPEGEncoder(fos, param);
					encoder.encode(bufImg);

					fos.close();
					// 构建文件视图描述
					fileView.setType(type);
					fileView.setName(cusDir + "/" + name + type);
					fileView.setPath(fixDir + fileView.getName());
					fileView.setSize(String.valueOf(new File(path).length() / 1024));
				}
			}
			return fileView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			path = null;
			image = null;
			bufImg = null;
			fos = null;
			param = null;
			encoder = null;
			fileView = null;
		}
	}

	/**
	 * 裁切图片
	 * 
	 * @param file
	 * @param realDir
	 * @param fixDir
	 * @param cusDir
	 * @param name
	 * @param type
	 * @param zoom
	 * @return
	 */
	public ImageAttr resize(File file, String realDir, String fixDir, String cusDir, String name, String type,
			float zoom) {
		String path = null;
		Image image = null;
		BufferedImage bufImg = null;
		FileOutputStream fos = null;
		JPEGImageEncoder encoder = null;
		ImageAttr fileView = null;
		try {
			// 获取图像文件
			image = ImageIO.read(file);

			// 如果不需要压缩图片
			if (image.getWidth(null) < zoom && image.getHeight(null) < zoom) {
				return this.create(file, realDir, fixDir, cusDir, name, type, null);
			} else {
				// 获取目录
				path = realDir + File.separator + cusDir;

				// 如果目录存在
				if (this.checkDir(path)) {
					// 构建文件描述视图
					fileView = new ImageAttr();
					float size = 0;

					// 如果宽大于高则重新计算面积大小
					if (image.getWidth(null) > image.getHeight(null)) {
						size = image.getWidth(null) / zoom;
					} else {
						size = image.getHeight(null) / zoom;
					}

					// 设置新的宽度和高度
					fileView.setWidth(Math.round(image.getWidth(null) / size));
					fileView.setHeight(Math.round(image.getHeight(null) / size));

					// 构建图片缓冲区
					bufImg = new BufferedImage(fileView.getWidth(), fileView.getHeight(), BufferedImage.TYPE_INT_RGB);

					// 输出图片
					bufImg.getGraphics().drawImage(
							image.getScaledInstance(fileView.getWidth(), fileView.getHeight(),
									BufferedImage.SCALE_SMOOTH), 0, 0, null);
					name = name + '-' + fileView.getWidth() + "x" + fileView.getHeight();
					path = path + File.separator + name + type;
					fos = new FileOutputStream(path);

					encoder = JPEGCodec.createJPEGEncoder(fos);
					encoder.encode(bufImg);

					fos.close();

					// 设置压缩后的存储大小
					fileView.setSize(String.valueOf(new File(path).length() / 1024));
					fileView.setType(type);
					fileView.setName(cusDir + "/" + name + type);
					fileView.setPath(fixDir + fileView.getName());

				}
			}
			return fileView;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			path = null;
			image = null;
			bufImg = null;
			fos = null;
			encoder = null;
			fileView = null;
		}

	}

	/**
	 * 裁切图中间区域
	 * 
	 * @param path
	 * @param w
	 * @param h
	 * @return
	 */
	public String cut(String path, Integer w, Integer h) {
		Integer x = 0;
		Integer y = 0;
		File srcFile = null;
		File dstFile = null;
		String dstName = null;
		String srcType = null;
		BufferedImage srcBufImg = null;
		BufferedImage dstBufImg = null;
		try {
			// 获取原图文件
			srcFile = new File(ContextHelper.getRealPath(path));
			srcType = srcFile.getName().substring(srcFile.getName().indexOf(".") + 1);
			srcBufImg = ImageIO.read(srcFile);

			// 根据坐标和大小切割
			dstBufImg = new BufferedImage(srcBufImg.getWidth(), srcBufImg.getHeight(), BufferedImage.TYPE_INT_RGB);
			dstBufImg.getGraphics().drawImage(
					srcBufImg.getScaledInstance(srcBufImg.getWidth(), srcBufImg.getHeight(), Image.SCALE_SMOOTH), 0, 0,
					null);

			// 如果原图的宽度大于切割宽度
			if (srcBufImg.getWidth() > w) {
				x = Math.round((srcBufImg.getWidth() - w) / 2);
			} else {
				x = 0;
				w = srcBufImg.getWidth();
			}

			// 如果原图的高度大于切割高度
			if (srcBufImg.getHeight() > h) {
				y = Math.round((srcBufImg.getHeight() - h) / 2);
				h = srcBufImg.getHeight();
			}

			// 新的文件名
			dstName = UUID.randomUUID().toString() + '-' + w + 'x' + h + "." + srcType;

			// 生成新的图片
			dstFile = new File(srcFile.getParent(), dstName);
			ImageIO.write(dstBufImg.getSubimage(x, y, w, h), srcType, dstFile);

			return dstName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			x = 0;
			y = 0;
			srcFile = null;
			dstFile = null;
			dstName = null;
			srcType = null;
			srcBufImg = null;
			dstBufImg = null;
		}
	}

	/**
	 * 图片缓冲
	 * 
	 * @param image
	 * @return
	 */
	public BufferedImage toBufferefImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}

		// 以根据Image绘制Icon
		image = new ImageIcon(image).getImage();
		BufferedImage bimage = null;

		// 返回本地 GraphicsEnvironment
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			// 透明度
			int transparency = Transparency.OPAQUE;

			// 返回默认的屏幕 GraphicsDevice
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException r) {
		}
		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();

		return bimage;
	}

}
