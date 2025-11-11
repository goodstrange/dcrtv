package com.dcrtv.dcrtvbackend.service.impl;

import com.dcrtv.dcrtvbackend.service.UserService;
import com.dcrtv.dcrtvbackend.tool.ApiResult;
import com.dcrtv.dcrtvbackend.tool.CookieTool;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public RedisTemplate<String,String> redisTemplate;


    //数字验证码登录（含自动注册）
    @Override
    public ApiResult loginVerify(String number, String code, HttpServletResponse response) {
        if (redisTemplate.hasKey(number)){
            if (redisTemplate.opsForValue().get(number).equals(code)){
                //1.存入用户基本信息

                //2.维持用户登录状态
                String token= UUID.randomUUID().toString();
                //将token存入cookie
                CookieTool.setCookie(response,"user-token:",token);
                //将token存入redis
                redisTemplate.opsForValue().set(token,null,3*24, TimeUnit.HOURS);
                return ApiResult.success("登录成功");
            }
            else {
                return ApiResult.error("验证码错误");
            }
        }
        return ApiResult.error("验证码错误");
    }
}
