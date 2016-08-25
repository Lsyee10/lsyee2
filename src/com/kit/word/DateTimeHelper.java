/**
 * 
 */
package com.kit.word;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Description:时间类
 * 
 * @author LSY
 * 
 */
public class DateTimeHelper {

	/**
	 * 获取当前时间戳
	 * 
	 * @return
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static Date getDate() {
		return new Date(System.currentTimeMillis());
	}
}
