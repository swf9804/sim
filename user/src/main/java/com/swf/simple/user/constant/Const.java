package com.swf.simple.user.constant;


public class Const {

	/**
	 * 默认的访问 Token 的 HTTP 请求头的名字
	 */
	public static final String ACCESS_TOKEN_HEADER_NAME = "X-Access-Auth-Token";

	/**
	 * 用户 Session 的 key prefix
	 */
	public static final String SERVER_USER_KEY = "USER_";

	/**
	 * 用户 Session 过期时间(单位:秒，1天)
	 */
	public static final int SERVER_USER_EXP_KEY = 60 * 60 * 24 * 1;


	/**
	 * 配送距离
	 */
	public static final int DISTRIBUTION_DISTANCE = 2000;

	
}
