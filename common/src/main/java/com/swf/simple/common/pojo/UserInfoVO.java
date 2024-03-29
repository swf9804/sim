package com.swf.simple.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/17 0:15
 **/
@Data
public class UserInfoVO extends BaseUser {
    private String phone;

    private String email;

    private String nickname;

    private String picture;

    private Byte sex;

    private Date createTime;
}
