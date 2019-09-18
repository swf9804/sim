package com.swf.simple.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.swf.simple.common.exception.BusinessException;
import com.swf.simple.common.util.MD5Util;
import com.swf.simple.user.service.UserService;
import com.swf.simple.user.entity.User;
import com.swf.simple.user.mapper.UserMapper;
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
        String psd = MD5Util.toMD5(password);
//        return userMapper.selectOne(new QueryWrapper<User>()
//                .eq("username", username)
//                .eq("password", password)
//        );
        return userMapper.selectOne(new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username)
                .eq(User::getPassword, psd)
        );
    }

    @Override
    public User register(User user) {
        String psd = user.getPassword();
        user.setPassword(MD5Util.toMD5(psd));
        int resultCount = userMapper.insert(user);
        if(resultCount == 0){
            throw new BusinessException("用户注册失败");
        }

        return login(user.getUsername(),psd);
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 查看指定username是否存在
     *
     * @param username
     * @return
     */
    @Override
    public Integer countByUsername(String username) {
        return userMapper.selectCount(new LambdaQueryWrapper<User>()
                .eq(User::getUsername,username)
        );
    }

    /**
     * 查看指定phone是否存在
     *
     * @param phone
     * @return
     */
    @Override
    public Integer countByPhone(String phone) {
        return userMapper.selectCount(new LambdaQueryWrapper<User>()
                .eq(User::getPhone,phone)
        );
    }

    /**
     * 查看指定emial是否存在
     *
     * @param emial
     * @return
     */
    @Override
    public Integer countByEmial(String emial) {
        return userMapper.selectCount(new LambdaQueryWrapper<User>()
                .eq(User::getEmail,emial)
        );
    }


}
