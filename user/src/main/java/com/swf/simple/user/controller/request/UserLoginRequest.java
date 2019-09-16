package com.swf.simple.user.controller.request;

import com.swf.simple.user.constant.Regex;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author SWF
 * @date 2019/9/15 20:12
 **/
@Data
public class UserLoginRequest {
    @Pattern(regexp = Regex.REGEX_USERNAME, message = "用户名格式不正确")
    String username;
    @Pattern(regexp = Regex.REGEX_PASSWORD, message = "密码格式不正确")
    String password;
}
