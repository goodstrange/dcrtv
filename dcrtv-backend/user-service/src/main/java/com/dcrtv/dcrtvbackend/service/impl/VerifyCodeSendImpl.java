package com.dcrtv.dcrtvbackend.service.impl;

import com.dcrtv.dcrtvbackend.service.VerifyCodeSend;
import com.dcrtv.dcrtvbackend.tool.ApiResult;

import java.util.regex.Pattern;

public class VerifyCodeSendImpl implements VerifyCodeSend {

    // 邮箱正则表达式
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // 手机号正则表达式
    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";

    @Override
    public ApiResult code(String number) {
        if (number.matches(PHONE_REGEX)){
            System.out.println("手机类型");
            //生成验证码
            return ApiResult.success("发送成功");
        }
        if (number.matches(EMAIL_REGEX)){
            System.out.println("邮箱类型");
            return ApiResult.success("验证码");
        }
        return ApiResult.error("类型错误");
    }
}
