package com.swf.simple.user.service;

import com.swf.simple.common.pojo.UserInfoVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author SWF
 * @date 2019/9/17 0:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSessionServiceTest {

    @Autowired
    private UserSessionService<UserInfoVO> userSessionService;

    @Test
    public void getUser(){
        UserInfoVO userInfoVO = userSessionService.getSession("12213",UserInfoVO.class);
        System.out.println(userInfoVO);
    }

}