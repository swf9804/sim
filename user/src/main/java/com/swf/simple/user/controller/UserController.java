package com.swf.simple.user.controller;

import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.request.UserLoginRequest;
import com.swf.simple.user.request.UserRegisterRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/login")
    public User login(@Valid UserLoginRequest bean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.login(bean.getUsername(),bean.getPassword());
    }

    @PostMapping("/register")
    public User register(UserRegisterRequest bean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = new User();
        BeanUtils.copyProperties(bean,user);
        return userService.register(user);
    }
}
