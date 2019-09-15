package com.swf.simple.user.request;

import com.swf.simple.user.constant.Regex;
import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author SWF
 * @date 2019/9/15 20:12
 **/
@Data
public class UserLoginRequest {
    @Pattern(regexp = Regex.REGEX_USERNAME, message = "姓名必须为汉字")
    String username;
    @Pattern(regexp = Regex.REGEX_PASSWORD, message = "姓名必须为汉字")
    String password;
}
