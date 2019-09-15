package com.swf.simple.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.swf.simple.user.constant.Const;
import com.swf.simple.user.service.UserSessionService;
import com.swf.simple.user.utils.RedisUtil;
import com.swf.simple.user.utils.StringUtil;
import com.swf.simple.user.vo.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SWF
 * @date 2019/9/15 21:31
 **/
@Service
public class RedisUserSessionServiceImpl<T extends BaseUser> implements UserSessionService<T> {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 缓存用户信息，JSON格式
     * @param request
     * @param user
     */
    @Override
    public T saveSession(HttpServletRequest request, T user) {
        // 生成token
        String token = generateAccessToken(request);
        user.setAccessToken(token);
        // 将用户数据转为json格式
        String userJson = JSON.toJSONString(user);
        // 拼装accessKey
        String accesskey = Const.SERVER_USER_KEY + user.getId();
        // 判断数据是否已经存在
        if (redisUtil.hasKey(accesskey)) {
            // 删除已存在的数据
            redisUtil.del((String) redisUtil.get(accesskey));
        }
        // token : data
        redisUtil.set(Const.SERVER_USER_KEY + token, userJson, Const.SERVER_USER_EXP_KEY);
        // accesskey : token
        redisUtil.set(accesskey, Const.SERVER_USER_KEY + token, Const.SERVER_USER_EXP_KEY);
        return user;
    }

    /**
     * 获取缓存用户，不为空，重新设置缓存中用户的过期时间
     * @param request
     * @return
     */
    @Override
    public T getSession(HttpServletRequest request, Type type) {
        String key = getUserSessionKey(request);
        String jsonStr = (String) redisUtil.get(key);

        if (StringUtil.isBlank(jsonStr)) {
            // ExceptionUtil.throwException(Errors.SYSTEM_NOT_LOGIN);
            return null;
        }
        return JSON.parseObject(jsonStr,type);
    }

    /**
     * 根据accessToken获取缓存用户
     * @param accessToken
     * @return
     */
    @Override
    public T getSession(String accessToken,Type type) {
        String jsonStr = (String) redisUtil.get(accessToken);

        if (StringUtil.isBlank(jsonStr)) {
            // ExceptionUtil.throwException(Errors.SYSTEM_NOT_LOGIN);
            return null;
        }
        return JSON.parseObject(jsonStr,type);
    }

    /**
     * 删除缓存中得用户信息
     *
     * @param request
     */
    @Override
    public void removeSession(HttpServletRequest request,Type type) {
        String key = getUserSessionKey(request);
        String jsonStr = (String) redisUtil.get(key);
        if (StringUtil.isNotBlank(jsonStr)) {
            String accesskey = Const.SERVER_USER_KEY + ((T)(JSON.parseObject(jsonStr, type))).getId();
            redisUtil.del(accesskey);
            redisUtil.del(key);
        }
    }

    private String generateAccessToken(HttpServletRequest request) {
        return request.getSession().getId() + StringUtil.uuidNotLine();
    }


    /**
     * 拼装request传入的key
     * @param request
     * @return
     */
    private String getUserSessionKey(HttpServletRequest request) {
        String key = Const.SERVER_USER_KEY + getSessionKey(request);
        return key;
    }

    /**
     * <pre>
     * 获取request传入的key
     * 同时使用，使用token保存登录信息，优先使用token，如果获取失败则取session
     * </pre>
     * @param request
     */
    private String getSessionKey(HttpServletRequest request) {
        String sessionId = "";
        Object sessionIdAttribute = request.getAttribute(Const.ACCESS_TOKEN_HEADER_NAME);

        if (StringUtil.isNotBlank(sessionIdAttribute)) {
            sessionId = sessionIdAttribute.toString();
        }
        if (StringUtil.isBlank(sessionId)) {
            sessionId = request.getHeader(Const.ACCESS_TOKEN_HEADER_NAME); // request 请求头
        }
        if (StringUtil.isBlank(sessionId)) {
            sessionId = request.getParameter("token");// 携带token参数
        }
        if (StringUtil.isBlank(sessionId)) {
            sessionId = request.getSession().getId();
        }
        return sessionId;
    }
}
