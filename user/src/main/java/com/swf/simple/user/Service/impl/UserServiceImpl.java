package com.swf.simple.user.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.swf.simple.user.Service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.mapper.UserMapper;
import com.swf.simple.user.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author SWF
 * @date 2019/9/14 16:46
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
//        return userMapper.selectOne(new QueryWrapper<User>()
//                .eq("username", username)
//                .eq("password", password)
//        );
        return userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPassword, MD5Util.MD5(password))
        );
    }

    @Override
    public User register(User user) {
        String psd = MD5Util.MD5(user.getPassword());
        user.setPassword(psd);
        userMapper.insert(user);
        return user;
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectById(id);
    }


}
