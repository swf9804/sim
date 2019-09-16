package com.swf.simple.user.controller;

import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.request.UserLoginRequest;
import com.swf.simple.user.request.UserRegisterRequest;
import com.swf.simple.user.service.UserSessionService;
import com.swf.simple.user.utils.ResponseVoUtil;
import com.swf.simple.user.vo.ResponseVO;
import com.swf.simple.user.vo.UserVO;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private UserSessionService<UserVO> userSessionService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseVO<UserVO> login(@Valid UserLoginRequest bean, BindingResult bindingResult, HttpServletRequest request){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = userService.login(bean.getUsername(),bean.getPassword());
        UserVO userVO = new UserVO();
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
