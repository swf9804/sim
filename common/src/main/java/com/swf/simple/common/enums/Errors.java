package com.swf.simple.common.enums;

import lombok.Getter;

@Getter
public enum Errors {
    // 0-200 系统级
    SUCCESS(0, "操作成功"),
    //
    SYSTEM_ERROR(1, "系统错误"),
    //
    SYSTEM_CUSTOM_ERROR(2, "自定义错误"),
    //
    SYSTEM_DATA_ERROR(3, "数据异常"),
    //
    SYSTEM_DATA_NOT_FOUND(4, "数据不存在"),
    //
    SYSTEM_NOT_LOGIN(5, "请登录"),
    //
    SYSTEM_UPDATE_ERROR(6, "数据更新失败"),
    //
    SYSTEM_NO_ACCESS(7, "无权限访问"),
    //
    SYSTEM_REQUEST_PARAM_ERROR(8, "请求参数错误"),

    SYSTEM_BUSINESS_ERROR(9, "系统繁忙,请您稍后再试"),

    SYSTEM_INSERT_ERROR(10,"已存在"),

    SYSTEM_INSERT_FAIL(11,"数据添加失败"),

    SYSTEM_DELETE_FAIL(12,"数据删除失败"),

    // 201-300，用户模块
    USER_LOGIN_ERROR(201, "用户名或密码错误"),
    //
    USER_PASSWORD_LENGTH(202, "密码长度不符合要求"),
    //
    USER_USERNAME_SAME(203, "该用户名已存在"),
    //
    USER_PASSWORD_SAME(204, "密码不能与老密码重复"),
    //
    USER_NOT_FIND(205, "用户不存在"),
    //
    USER_HAS_DELETED(206, "该用户已经失效"),
    //
    USER_ACCOUNT_ERROR(207, "帐号异常，请联系客服"),
    //
    USER_OLD_PASSWORD_ERROR(208, "原密码错误"),
    //
    USER_HAS_DISABLED(209, "该用户已经被禁用"),

    // 短信发送模块
    USER_MOBILE_EXISTS(210, "该手机号已经注册"),
    //
    USER_MOBILE_NOT_REGISTER(211, "该手机号并未注册"),
    //
    USER_SMS_SEND_FAST(212, "请30秒后再试"),
    //
    USER_SMS_SEND_ERROR(213, "短信接口调用失败"),
    //
    CAPTCHA_IS_NULL(214, "验证码不存在"),
    //
    CAPTCHA_EXPIRED(215, "验证码已过期"),
    //
    CAPTCHA_ERROR(216,"验证码输入有误"),
    //
    WEIXIN_USER_NOT_LOGIN(217,"微信用户未登陆"),
    //
    BIND_CARD_CODE(218,"该手机号不存在"),
    //
    BIND_CARD_HAS(219,"此手机号已经被绑定"),

    // 300 - 400 商品模块
    PRODUCT_NOT_EXIST(301 , "商品不存在"),

    PRODUCT_STOCK_ERROR(302 , "商品库存不足"),

    ORDER_NOT_EXIST(303,"订单不存在"),

    ORDER_STATUS_ERROR(304,"订单状态不正确"),

    SHOP_NOT_EXIST(305 , "商铺不存在"),

    SHOP_HAS_DISABLED(306, "该商铺已被禁用"),

    SHOP_NOT_OWNER(307 , "该商铺没有负责人"),

    // 400 - 500
    COUPONS_STOCK_ERROR(401,"优惠券库存不足"),

    COUPONS_NOT_EXIST(402,"优惠券不存在"),

    COUPONS_ACTIVITY_HAVE_DISABLE(403,"该活动已失效"),

    COUPONS_HAVE_TO_RECEIVE(405,"您已经领取过此优惠券"),

    COUPONS_RECEIVE_FAIL(406,"优惠券领取失败,请重试")
    ;

    private int code;
    private String message;

    private Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }

}