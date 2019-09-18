package com.swf.simple.user;

import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("swf");
        user.setPassword("123456");
        user.setNickname("校网");
        user.setSex((byte) 1);
        System.out.println(userService.register(user));
        userService.login("swf","123456");
    }

}
