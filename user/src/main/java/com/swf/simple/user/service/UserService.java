package com.swf.simple.user.service;

import com.swf.simple.user.entity.User;

/**
 * @author SWF
 * @date 2019/9/13 16:30
 **/
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User login(String username,String password);

    /**
     * 注册，并登录
     * @param user
     * @return
     */
    User register(User user);

    /**
     * 根据id查看
     * @param id
     * @return
     */
    User get(Integer id);

    /**
     * 查看指定username是否存在
     * @param username
     * @return
     */
    Integer countByUsername(String username);

    /**
     * 查看指定phone是否存在
     * @param phone
     * @return
     */
    Integer countByPhone(String phone);

    /**
     * 查看指定emial是否存在
     * @param emial
     * @return
     */
    Integer countByEmial(String emial);
}
