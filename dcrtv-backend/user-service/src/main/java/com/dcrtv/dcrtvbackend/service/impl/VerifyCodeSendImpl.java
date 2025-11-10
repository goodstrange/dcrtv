package com.dcrtv.dcrtvbackend.service.impl;

import com.dcrtv.dcrtvbackend.service.VerifyCodeSend;
import com.dcrtv.dcrtvbackend.tool.ApiResult;
import com.dcrtv.dcrtvbackend.tool.VerifyCodeBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@Service
public class VerifyCodeSendImpl implements VerifyCodeSend {

    // 邮箱正则表达式
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // 手机号正则表达式
    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    /**
     * 获取数字验证码
     *
     * @param number
     * @return
     */
    @Override
    public ApiResult code(String number) {
        if (number.matches(PHONE_REGEX)) {
            //System.out.println("手机类型");
            String code = VerifyCodeBuild.buildCode();
            System.out.println(code);
            //判断同一用户60s内是否多次获取验证码防刷
            if (!redisTemplate.hasKey(number)) {
                redisTemplate.opsForValue().set(number, code, 60, TimeUnit.SECONDS);
                return ApiResult.success("发送成功");
            } else {
                return ApiResult.error("请等待60s后获取");
            }

        } else if (number.matches(EMAIL_REGEX)) {
            //System.out.println("邮箱类型");
            String code = VerifyCodeBuild.buildCode();
            System.out.println(code);
            //判断同一用户60s内是否多次获取验证码防刷
            if (!redisTemplate.hasKey(number)) {
                redisTemplate.opsForValue().set(number, code, 60, TimeUnit.SECONDS);
                return ApiResult.success("发送成功");
            } else {
                return ApiResult.error("请等待60s后获取");
            }
        }
        return ApiResult.error("格式不正确");
    }
}
