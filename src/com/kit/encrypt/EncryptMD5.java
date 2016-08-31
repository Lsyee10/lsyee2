/**
 * 
 */
package com.kit.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description:MD5加密
 *
 * @version 1.0 2016年5月6日
 * @author LSY
 */
public class EncryptMD5 {

	public static String eccrypt(String info) throws NoSuchAlgorithmException{
		StringBuffer rst = new StringBuffer();
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		try {
			md5.update(info.getBytes("UTF-8"));
			byte[] md5Bytes = md5.digest();
			int digital;
			for (int i = 0; i < md5Bytes.length; i++) {
				digital = md5Bytes[i];
				if (digital < 0) {
					digital += 256;
				}
				if (digital < 16) {
					rst.append("0");
				}
				rst.append(Integer.toHexString(digital));
			}
			return rst.toString();
		} catch (Exception e) {
			return null;
		} finally {
			md5 = null;
			rst = null;
		}
	}
}
