package com.swf.simple.user.controller;

import com.swf.simple.common.pojo.UserInfoVO;
import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.controller.request.UserLoginRequest;
import com.swf.simple.user.controller.request.UserRegisterRequest;
import com.swf.simple.user.service.UserSessionService;
import com.swf.simple.user.util.ResponseVoUtil;
import com.swf.simple.user.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author SWF
 * @date 2019/9/14 21:45
 **/
@RequestMapping
@RestController("/app")
public class UserController {

    @Autowired
    private UserService userService;

    @Reference
    private UserSessionService<UserInfoVO> userSessionService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseVO<UserInfoVO> login(@Valid UserLoginRequest bean, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = userService.login(bean.getUsername(),bean.getPassword());
        UserInfoVO userVO = new UserInfoVO();
        BeanUtils.copyProperties(user,userVO);
        userVO = userSessionService.saveSession(request,userVO);
        return ResponseVoUtil.success(userVO);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public User register(@Valid UserRegisterRequest bean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = new User();
        BeanUtils.copyProperties(bean,user);
        return userService.register(user);
    }
}
