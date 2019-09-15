package com.swf.simple.user.service;

import com.swf.simple.user.entity.User;

/**
 * @author SWF
 * @date 2019/9/13 16:30
 **/
public interface UserService {

    User login(String username,String password);

    User register(User user);

    User get(Integer id);
}
