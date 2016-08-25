package com.kit.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @version 1.0 2016年4月20日
 * @author LSY
 */
public class StringHelper {

	/**
	 * HTML到文本
	 * 
	 * @param str
	 * @return
	 */
	public static String html2Text(String str) {
		String sciprtReg = null;
		String styleReg = null;
		String tagDulReg = null;
		String tagSigReg = null;
		Pattern scriptPattern = null;
		Matcher scriptMatcher = null;
		Pattern stylePattern = null;
		Matcher styleMatcher = null;
		Pattern tagDulPattern = null;
		Matcher tagDulMatcher = null;
		Pattern tagSigPattern = null;
		Matcher tagSigMatcher = null;
		try {
			// 定义脚本的正则表达式
			sciprtReg = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";

			// 定义style的正则表达式
			styleReg = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";

			// 定义HTML含结束符标签的正则表达式
			tagDulReg = "<[^>]+>";

			// 定义HTML不含结束符标签的正则表达式
			tagSigReg = "<[^>]+";

			// 过滤script标签
			scriptPattern = Pattern.compile(sciprtReg, Pattern.CASE_INSENSITIVE);
			scriptMatcher = scriptPattern.matcher(str);
			str = scriptMatcher.replaceAll("");

			// 过滤style标签
			stylePattern = Pattern.compile(styleReg, Pattern.CASE_INSENSITIVE);
			styleMatcher = stylePattern.matcher(str);
			str = styleMatcher.replaceAll("");

			// 过滤HTML含结束符标签
			tagDulPattern = Pattern.compile(tagDulReg, Pattern.CASE_INSENSITIVE);
			tagDulMatcher = tagDulPattern.matcher(str);
			str = tagDulMatcher.replaceAll("");

			// 过滤HTML不含结束符标签
			tagSigPattern = Pattern.compile(tagSigReg, Pattern.CASE_INSENSITIVE);
			tagSigMatcher = tagSigPattern.matcher(str);
			str = tagSigMatcher.replaceAll("");

			// 过滤空格
			str = str.replace("&nbsp;", "");

			return str;
		} catch (Exception e) {
			return null;
		} finally {
			sciprtReg = null;
			styleReg = null;
			tagDulReg = null;
			tagSigReg = null;
			scriptPattern = null;
			scriptMatcher = null;
			stylePattern = null;
			styleMatcher = null;
			tagDulPattern = null;
			tagDulMatcher = null;
			tagSigPattern = null;
			tagSigMatcher = null;
		}

	}

	/**
	 * 过滤sql
	 * 
	 * @param str
	 * @return
	 */
	public static String sql2Text(String str) {
		String sqlReg = null;
		Pattern scriptPattern = null;
		Matcher scriptMatcher = null;
		try {
			// 定义sql的正则表达式
			sqlReg = "select|update|delete|truncate|join|union|exec|insert|drop|count|'|\"|;|>|<|%";

			// 过滤sql标签
			scriptPattern = Pattern.compile(sqlReg, Pattern.CASE_INSENSITIVE);
			scriptMatcher = scriptPattern.matcher(str);
			str = scriptMatcher.replaceAll("");

			return str;
		} catch (Exception e) {
			return null;
		} finally {
			sqlReg = null;
			scriptPattern = null;
			scriptMatcher = null;
		}
	}

	/**
	 * 过滤url
	 * 
	 * @param str
	 * @return
	 */
	public static String url2Text(String str) {
		String urlReg = null;
		Pattern ptn = null;
		Matcher mach = null;
		try {
			// 定义url的正则表达式
			urlReg = "(http(s)?://)?([\\w-]+\\.)+[\\w]+(/[\\w- ./?%&=]*)?";

			// 过滤url
			ptn = Pattern.compile(urlReg, Pattern.CASE_INSENSITIVE);
			mach = ptn.matcher(str);
			str = mach.replaceAll("");

			return str;
		} catch (Exception e) {
			return null;
		} finally {
			urlReg = null;
			ptn = null;
			mach = null;
		}
	}

	/**
	 * 判断字字符串是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean ifNull(String str) {
		if (null == str || "".equals(str.trim()) || str.trim().equalsIgnoreCase("null")) {
			return true;
		}
		return false;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> getAtNicknames(String str) {
		Pattern pat = null;
		Matcher mat = null;
		List<String> list = null;
		try {
			pat = Pattern.compile("@(.*?)\\s+");
			mat = pat.matcher(str);
			list = new ArrayList<String>(0);
			while (mat.find()) {
				// 获取第一个括号所匹配的内容
				list.add(mat.group(1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			pat = null;
			mat = null;
			list = null;
		}
	}

	/**
	 * // 判断是否为手机
	 * 
	 * @param str
	 * @return
	 */
	public static boolean ifMobile(String str) {
		return Pattern.compile("^1[3|4|5|7|8]\\d{9}$").matcher(str).matches();
	}

	/**
	 * 判断是否为邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static boolean ifMail(String str) {
		return Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")
				.matcher(str).matches();
	}

	/**
	 * 获取一定长度的随机数
	 * 
	 * @param Length
	 * @return
	 */
	public static String getRandomNumByLength(int length) {
		Random random = null;
		StringBuffer sb = null;
		String base = "012345789";
		try {
			random = new Random();
			sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				int num = random.nextInt(base.length());
				sb.append(base.charAt(num));
			}

			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			random = null;
			sb = null;
			base = null;
		}
	}

	/**
	 * 获取昵称
	 * 
	 * @param str
	 * @return
	 */
	public static String getAtNickname(String str) {
		Pattern pat = null;
		Matcher mat = null;
		try {
			pat = Pattern.compile("@(.*?)\\s+");
			mat = pat.matcher(str);
			if (mat.find()) {
				return mat.group(1);
			}
			return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			pat = null;
			mat = null;
		}
	}

	/**
	 * 缩写处理
	 * 
	 * @param str
	 * @param width
	 * @param ellipsis
	 * @return
	 */
	public static String abbreviate(String str, int width, String ellipsis) {
		Integer d = 0; // byte length
		Integer n = 0;// char length
		try {
			if (str == null || "".equals(str)) {
				return "";
			}

			for (; n < str.length(); n++) {
				d = (int) str.charAt(n) > 256 ? d + 2 : d + 1;// 是否为中文
				if (d > width) {
					break;
				}
			}

			if (d > width) {
				n = n - ellipsis.length() / 2;
				return str.substring(0, n > 0 ? n : 0) + ellipsis;
			}

			return str = str.substring(0, n);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			d = null;
			n = null;
		}
	}

	/**
	 * 获取标签列表
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> getTags(String str) {
		Pattern ptn = null;
		Matcher mat = null;
		List<String> list = null;
		try {
			ptn = Pattern.compile("#(.*?)\\s+");
			mat = ptn.matcher(str);
			list = new ArrayList<String>(0);
			while (mat.find()) {
				list.add(mat.group(1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			ptn = null;
			mat = null;
			list = null;
		}
	}
}
