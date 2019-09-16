package com.swf.simple.common.pojo;

import lombok.Data;

/**
 * @author SWF
 * @date 2019/9/15 22:08
 **/
@Data
public class BaseUser {

    private Integer id;

    private String username;

    private String accessToken;
}
