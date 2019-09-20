package com.swf.simple.user.controller;

import com.swf.simple.common.enums.Errors;
import com.swf.simple.common.exception.BusinessException;
import com.swf.simple.common.pojo.UserInfoVO;
import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.controller.request.UserLoginRequest;
import com.swf.simple.user.controller.request.UserRegisterRequest;
import com.swf.simple.user.service.UserSessionService;
import com.swf.simple.user.util.ResponseVoUtil;
import com.swf.simple.user.vo.ResponseVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author SWF
 * @date 2019/9/14 21:45
 **/
//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600) // 解决跨域的注解
@RestController
@RequestMapping("/app")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserSessionService<UserInfoVO> userSessionService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseVO<UserInfoVO> login(@Valid @RequestBody UserLoginRequest bean, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = userService.login(bean.getUsername(), bean.getPassword());
        if (user == null) {
            throw new BusinessException(Errors.USER_LOGIN_ERROR);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        // 保存 Session
        userInfoVO = userSessionService.saveSession(request, userInfoVO);
        return ResponseVoUtil.success(userInfoVO);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResponseVO<UserInfoVO> register(@Valid UserRegisterRequest bean, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = new User();
        BeanUtils.copyProperties(bean, user);
        user = userService.register(user);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(user, userInfoVO);
        // 保存 Session
        userInfoVO = userSessionService.saveSession(request, userInfoVO);
        return ResponseVoUtil.success(userInfoVO);
    }

    @ApiOperation("getSession")
    @GetMapping("/get")
    public ResponseVO<UserInfoVO> getBySession(HttpServletRequest request) {
        UserInfoVO userInfoVO = userSessionService.getSession(request, UserInfoVO.class);
        return ResponseVoUtil.success(userInfoVO);
    }
}
