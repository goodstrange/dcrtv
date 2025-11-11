package com.dcrtv.dcrtvbackend.tool;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * 拦截器功能：1.登录状态续签
 */
@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //Cookie中保存token的键名
    private static final String COOKIE_TOKEN_NAME="user-token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = CookieTool.getCookie(request,COOKIE_TOKEN_NAME);

            //检查cookie中是否有该token
            if (token==null||token.trim().isEmpty()){
                return true;//用户未登录，不影响正常访问网站
            }

            //检查token是否存在redis中
            if (!redisTemplate.hasKey(token)){
                CookieTool.removeCookie(response,COOKIE_TOKEN_NAME);
                return true;
            }

            //自动续签cookie和redis中的token，维持用户登录状态
            CookieTool.setCookie(response,COOKIE_TOKEN_NAME,token);
            redisTemplate.opsForValue().set(token,null,3*24, TimeUnit.HOURS);
        } catch (Exception e) {
            log.error("登陆状态续签异常",e);
        }
        return true;
    }
}
