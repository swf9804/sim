package com.swf.simple.user.interceptor;

import com.swf.simple.user.constant.Const;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author SWF
 * @Date 2019/3/21 16:19
 **/
@Component
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //跨域请求，*代表允许全部类型
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");

        //允许请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");

        //请求包含的字段内容，如有多个可用哪个逗号分隔如下
        // response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
        response.addHeader("Access-Control-Allow-Headers", Const.ACCESS_TOKEN_HEADER_NAME + ",  Origin, Content-Type, Cookie,");

        //用来指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
        response.setHeader("Access-Control-Max-Age", "3600");

        // 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 如果是option请求，直接返回200
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        // 传递业务请求处理
        chain.doFilter(servletRequest, servletResponse);


    }

    @Override
    public void destroy() {

    }
}