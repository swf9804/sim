package com.swf.simple.user.constant;


public class Const {

	public static final String ADMIN="currentUser";
	public static final String USERNAME = "account";
	public static final String EMAIL = "email";
	public static final String PHONE = "phone";
	public static final String VERIFY_CODE="verifyCode";
	
	/**
	 * 默认的访问Token的HTTP请求头的名字
	 */
	public static final String ACCESS_TOKEN_HEADER_NAME = "X-Access-Auth-Token";

	/**
	 * 缓存用户的key,USER_; USER_1
	 */
	public static final String SERVER_USER_KEY = "USER_";

	/**
	 * 用户过期时间(单位:秒，1天)
	 */
	public static final int SERVER_USER_EXP_KEY = 60 * 60 * 24 * 1;

	/**
	 * 端来源-请求头key
	 */
	public static final String REQUEST_SIDE_HEAD_NAME = "X-REQUEST-SIDE";

	/**
	 * 配送距离
	 */
	public static final int DISTRIBUTION_DISTANCE = 2000;

	
}
