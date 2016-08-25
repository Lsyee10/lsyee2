/**
 * 
 */
package com.kit.word;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

/**
 * Description:jodaTime时间类
 *
 * @version 1.0 2016年4月20日
 * @author LSY
 */
public class JodaTimeHelper {

	/**
	 * 获取当前日期
	 * 
	 * @return
	 */
	public static String getDate() {
		try {
			return new LocalDate().toString("yyyy-MM-dd");
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
	 * 通过时间戳获取java.sql.Date类型
	 * 
	 * @param timestamp
	 * @return
	 */
	public static Date getDate(Timestamp timestamp) {
		return new Date(new LocalDate(timestamp).toDate().getTime());
	}

	/**
	 * 通过sql.Date获取String日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getDate(Date date) {
		try {
			return new DateTime(date).toString("yyyy-MM-dd");
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
	 * 通过时间戳获取月份
	 * 
	 * @param timestamp
	 * @return
	 */
	public static Integer getMonth(Timestamp timestamp) {
		return new LocalDate(timestamp).getMonthOfYear();
	}

	/**
	 * 通过时间戳获取日
	 * 
	 * @param timestamp
	 * @return
	 */
	public static Integer getDay(Timestamp timestamp) {
		return new LocalDate(timestamp).getDayOfMonth();
	}

	/**
	 * 获取年份
	 * 
	 * @return
	 */
	public static String getYear() {
		return new LocalDate().toString("yyyy");
	}

	/**
	 * 获取日期
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthDay(Date date) {
		return new DateTime(date).toString("MM-dd");
	}

	/**
	 * 与当前时间比较，一天前用日期
	 * 
	 * @param addTime
	 * @return
	 */
	public static String getBeforeNowDay(Timestamp addTime) {
		return null;
	}

	/**
	 * 当前时间比较
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String getBeforeNow(Timestamp timestamp) {
		DateTime now = null;
		DateTime dt = null;
		try {
			now = new DateTime();
			dt = new DateTime(timestamp);

			int years = Years.yearsBetween(dt, now).getYears();

			if (years > 0) {
				return String.valueOf(years) + "年前";
			} else {
				int months = Months.monthsBetween(dt, now).getMonths();

				if (months > 0) {
					return String.valueOf(months) + "月前";
				} else {
					int days = Days.daysBetween(dt, now).getDays();

					if (days > 0) {
						return String.valueOf(days) + "日前";
					} else {
						int hours = Hours.hoursBetween(dt, now).getHours();

						if (hours > 0) {
							return String.valueOf(hours) + "小时前";
						} else {
							int minutes = Minutes.minutesBetween(dt, now).getMinutes();

							if (minutes > 0) {
								return String.valueOf(minutes) + "分钟前";
							} else {
								int seconds = Seconds.secondsBetween(dt, now).getSeconds();

								if (seconds > 0) {
									return String.valueOf(seconds) + "秒钟前";
								} else {
									return "刚刚";
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return null;
		} finally {
			now = null;
			dt = null;
		}
	}

}
