package com.swf.simple.user.service;

import com.swf.simple.common.pojo.BaseUser;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * @author SWF
 * @date 2019/9/15 21:25
 **/
public interface UserSessionService<T extends BaseUser>{
    /**
     * 缓存用户信息，JSON格式
     * @param request
     * @param user
     */
    T saveSession(HttpServletRequest request, T user);

    /**
     * 获取缓存用户，不为空，重新设置缓存中用户的过期时间
     * @param request
     * @return
     */
    T getSession(HttpServletRequest request, Type type);

    /**
     * 根据accessToken获取缓存用户
     * @param accessToken
     * @return
     */
    T getSession(String accessToken, Type type);

    /**
     * 删除缓存中得用户信息
     * @param request
     */
    void removeSession(HttpServletRequest request, Type type);

}
