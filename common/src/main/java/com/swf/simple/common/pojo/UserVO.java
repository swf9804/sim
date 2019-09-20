package com.swf.simple.common.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/20 23:00
 **/
@Data
public class UserVO {
    private Integer id;

    private String username;

    private String nickname;

    private String picture;

    private Byte sex;

}
