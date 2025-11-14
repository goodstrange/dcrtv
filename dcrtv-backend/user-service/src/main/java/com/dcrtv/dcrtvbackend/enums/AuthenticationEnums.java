package com.dcrtv.dcrtvbackend.enums;

import com.dcrtv.dcrtvbackend.common.response.RCodeMsgEnum;

/**
 * 认证返回结果枚举类，标记响应状态码和响应消息
 */
public enum AuthenticationEnums implements RCodeMsgEnum {
    REGISTER_SUCCESS(201, "注册成功"),
    PHONE_REGISTERED(400, "该手机号已被注册"),
    VERIFY_ERROR_OR_EXPIRED(401, "验证码错误或已过期"),
    SEND_VERIFY_CODE_SUCCESS(200, "验证码发送成功"),
    VERIFY_CODE_ERROR(400, "图片验证码错误"),
    REQUEST_FREQUENT(429, "请求过于频繁，请60秒后再试"),
    PASSWORD_NOT_CONSISTENT(400, "密码不一致");

    private Integer code;
    private String message;

    AuthenticationEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
