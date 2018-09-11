package com.eureka.util;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public final class CommonUtil {

	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String md5Str(String password) {
		String plainText =  password.concat("2974de1ete2c48a0b9ab05f9abfb8359");
		String md5Str = null;
		try {
			StringBuffer buf = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			md5Str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5Str;
	}

	public static final String generateTeacherId(String schoolId){
		long nowDate = new Date().getTime();
		String sid = Integer.toUnsignedString((int)nowDate);
		Random rand = new Random();
		StringBuffer flag = new StringBuffer();
		for (int i = 0; i < 7; i++)
			flag.append(sid.charAt(rand.nextInt(9)) + "");

		String result = schoolId.concat(nowTime("yyyy")).concat(flag.toString());
		return result;
	}

	public static String nowTime(String formatStr) {
		return formatDate(System.currentTimeMillis(), formatStr);
	}

	private static String formatDate(Long dateTime, String formatStr) {
		String format = StringUtils.isEmpty(formatStr) ? DATETIME_PATTERN : formatStr;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(dateTime);
	}
}
