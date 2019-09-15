package com.swf.simple.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/13 16:36
 **/
@Data
@TableName("tb_user")
public class User {
    @TableId(type = IdType.AUTO)
    Integer id;

    String username;

    String password;

    String phone;

    String email;

    String nickname;

    String picture;

    Byte sex;

    Date createTime;

    Date updateTime;

}
