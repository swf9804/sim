package com.swf.simple.user.request;

import com.swf.simple.user.constant.Regex;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author SWF
 * @date 2019/9/15 19:58
 **/
@Data
public class UserRegisterRequest {

    @Pattern(regexp = Regex.REGEX_USERNAME, message = "姓名必须为汉字")
    String username;
    @Pattern(regexp = Regex.REGEX_PASSWORD, message = "姓名必须为汉字")
    String password;
    @Pattern(regexp = Regex.REGEX_CHINESE, message = "昵称必须为汉字")
    String nickname;

}
