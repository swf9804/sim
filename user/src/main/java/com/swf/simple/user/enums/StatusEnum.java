package com.swf.simple.user.enums;

import lombok.Getter;

/**
 * @Author SWF
 * @Date 2019/6/6 14:19
 **/
@Getter
public enum StatusEnum {
    // 管理员
    SUPER_ADMIN(8,"超级管理员"),

    // 用户类型,权限
    NORMAL_USER(1,"普通用户"),
    SELLER_USER(2,"卖家"),
    ADMIN(7,"管理员"),

    // 通用
    NORMAL(1,"正常"),
    DISABLED(0,"禁用"),
    DELETE(-1,"删除"),

    // 商品
    UP(1,"上架"),
    DOWN(0,"下架"),

    // 订单
//    NEW_ORDER(0,"新订单"),
//    ORDER_RECEIVE(1,"接单"),
//    ORDER_FINISHED(2,"完结订单"),
//    ORDER_CANCEL(3,"取消订单"),

    // 订单
    ORDER_UNPAID(0,"待付款"),
    ORDER_UNFILLED(1,"待发货/待接单"),
    ORDER_UNRECEIVED(2,"待收货/已接单"),
    ORDER_FINISHED(3,"已完成"),
    ORDER_CANCEL(4,"已取消"),


    // 支付
    PAY_WAIT(0, "等待支付"),
    PAY_SUCCESS(1, "支付成功"),


    ;
    private Byte code;

    private String label;

    private StatusEnum(int code , String label){
        this.code = new Byte((byte)code);
        this.label = label;
    }
}
