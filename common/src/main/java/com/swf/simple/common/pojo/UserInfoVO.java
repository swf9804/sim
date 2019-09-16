package com.swf.simple.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/17 0:15
 **/
@Data
public class UserInfoVO extends BaseUser {
    String phone;

    String email;

    String nickname;

    String picture;

    Byte sex;

    Date createTime;
}
