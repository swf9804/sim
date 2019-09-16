package com.swf.simple.user.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/16 20:37
 **/
@Data
public class UserVO extends BaseUser {

    String phone;

    String email;

    String nickname;

    String picture;

    Byte sex;

    Date createTime;

}
