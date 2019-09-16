package com.swf.simple.imserver.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.swf.simple.common.pojo.UserInfoVO;
import com.swf.simple.user.service.UserSessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author SWF
 * @date 2019/9/17 1:22
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Reference(check = false)
    private UserSessionService<UserInfoVO> userSessionService;

    @ResponseBody
    @GetMapping("/test")
    public UserInfoVO get(){
        UserInfoVO userInfoVO = userSessionService.getSession("12",UserInfoVO.class);
        System.out.println("adasd"+userInfoVO);
        return userInfoVO;
    }

}
