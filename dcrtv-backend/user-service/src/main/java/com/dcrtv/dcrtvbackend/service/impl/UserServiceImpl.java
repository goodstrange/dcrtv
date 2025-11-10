package com.dcrtv.dcrtvbackend.service.impl;

import com.dcrtv.dcrtvbackend.service.UserService;
import com.dcrtv.dcrtvbackend.tool.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public RedisTemplate<String,String> redisTemplate;


    @Override
    public ApiResult loginVerify(String number,String code) {
        if (redisTemplate.hasKey(number)){
            if (redisTemplate.opsForValue().get(number)==code){
                //存入用户基本信息并且维持用户登录状态
                return ApiResult.success("登录成功");
            }
            else {
                return ApiResult.error("验证码错误");
            }
        }
        return ApiResult.error("验证码错误");
    }
}
