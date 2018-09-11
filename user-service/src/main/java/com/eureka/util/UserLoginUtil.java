package com.eureka.util;

public final class UserLoginUtil {

	/**
	 * 密码校验
	 * @param userPassword 数据库中密码
	 * @param password     用户上传的密码
	 * @return
	 */
	public static final boolean loginCheck(String userPassword, String password){
		return CommonUtil.md5Str(password).equals(userPassword);
	}
}
