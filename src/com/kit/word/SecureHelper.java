/**
 * Project : kpkp
 * Copyright (c) Hang Zhou Daily Press Group. 
 * All rights reserved.
 */
package com.kit.word;

import java.util.HashSet;
import java.util.Set;

import com.kit.config.SystemConfig;

/**
 * Description: 安全帮助
 * 
 * @version 1.0 2015年10月2日
 * @author Wu guang jing
 * 
 */
public class SecureHelper {

	private static String FILTER_SENSITIVE_SQL = SystemConfig.getProperty("filter_sensitive_sql",
			"/sysConfig.properties");
	private static String FILTER_SENSITIVE_WORD = SystemConfig.getProperty("filter_sensitive_word",
			"/sysConfig.properties");

	private static String[] SENSITIVE_SQL = FILTER_SENSITIVE_SQL.split("\\|");
	private static Set<String> SENSITIVE_WORD = null;
	private static Set<Character> SENSITIVE_CHAR = null;

	/**
	 * 过滤SQL
	 * 
	 * @param str
	 * @return
	 */
	public static String filterSql(String str) {
		String rst = str.toLowerCase();// 统一转为小写
		try {
			for (String sql : SENSITIVE_SQL) {
				if (rst.indexOf(sql) >= 0) {
					rst = rst.replace(sql, "*");
				}
			}
			return rst;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			rst = null;
		}
	}

	/**
	 * 校验SQL
	 * 
	 * @param str
	 * @return
	 */
	public static boolean ifSql(String str) {
		String rst = str.toLowerCase();// 统一转为小写
		try {
			for (String sql : SENSITIVE_SQL) {
				if (rst.indexOf(sql) >= 0) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			rst = null;
		}
	}

	/**
	 * 过滤敏感词
	 * 
	 * @param text
	 * @return
	 */
	public static String filterWord(String text) {
		String key = null;
		Character word = null;
		StringBuffer replace = null;
		StringBuffer newText = new StringBuffer(text);
		try {
			// 如果敏感词库未初始化
			if (SENSITIVE_WORD == null || SENSITIVE_CHAR == null) {
				SENSITIVE_WORD = new HashSet<String>();
				SENSITIVE_CHAR = new HashSet<Character>();

				// 迭代
				for (String str : FILTER_SENSITIVE_WORD.split(",")) {

					// 添加敏感词
					SENSITIVE_WORD.add(str);

					// 迭代添加敏感字符
					for (Character c : str.toCharArray()) {
						SENSITIVE_CHAR.add(c);
					}
				}
			}

			// 迭代查询敏感词
			for (int i = 0; i < text.length(); i++) {
				word = text.charAt(i);

				// 如果敏感字符中不存在当前字符
				if (!SENSITIVE_CHAR.contains(word)) {
					continue;
				}

				int j = i;

				// 循环遍历
				while (j < text.length()) {

					// 如果敏感字符中不存在当前字符
					if (!SENSITIVE_CHAR.contains(word)) {
						break;
					}

					// 截取出当前字符串
					key = text.substring(i, j + 1);

					// 如果敏感词存在则替换为*
					if (SENSITIVE_WORD.contains(key)) {
						replace = new StringBuffer("");

						for (int k = i; k < j + 1; k++) {
							replace.append("*");
						}

						//敏感词替换
						newText.replace(i, j + 1, replace.toString());
					}
					j++;
				}
			}

			return newText.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return newText.toString();
		} finally {
			key = null;
			word = null;
			replace = null;
			newText = null;
		}
	}
}
