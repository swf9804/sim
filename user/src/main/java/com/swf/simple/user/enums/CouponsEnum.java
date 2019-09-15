package com.swf.simple.user.enums;

import lombok.Getter;

/**
 * @author SWF
 * @date 2019/6/21 10:07
 **/
@Getter
public enum CouponsEnum {

    // 优惠券状态
    STATUS_DELETE(-1, "已删除"),
    STATUS_DISABLED(0, "失效的，过期的"),
    STATUS_UNUSED(1,"未使用"),
    STATUS_USED(2, "已使用过"),

    // 优惠券类型
    TYPE_FIXED_DATE(1, "固定日期"),
    TYPE_FIXED_DURATION(2, "固定时长"),

    // 适用范围
    SCOPE_SHOP(2,"适用于指定店铺"),
    SCOPE_ALL(4, "适用于全场")
    ;

    private Byte code;

    private String label;

    private CouponsEnum(int code , String label){
        this.code = new Byte((byte)code);
        this.label = label;
    }
}
