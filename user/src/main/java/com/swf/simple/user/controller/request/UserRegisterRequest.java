package com.swf.simple.user.controller.request;

import com.swf.simple.user.constant.Regex;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author SWF
 * @date 2019/9/15 19:58
 **/
@Data
public class UserRegisterRequest {

    @Pattern(regexp = Regex.REGEX_USERNAME, message = "用户名格式不正确")
    String username;
    @Pattern(regexp = Regex.REGEX_PASSWORD, message = "密码格式不正确")
    String password;
    @Pattern(regexp = Regex.REGEX_CHINESE, message = "昵称必须为汉字")
    String nickname;

}
