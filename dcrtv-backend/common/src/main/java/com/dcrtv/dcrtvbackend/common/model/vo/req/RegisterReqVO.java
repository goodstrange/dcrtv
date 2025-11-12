package com.dcrtv.dcrtvbackend.common.model.vo.req;

/**
 * @author: chz
 * @description: 注册请求参数
 * @create: 2025-11-11 16:06
 * @param account: 登录的账户 eg: "13800138000_or_user@example.com"
 * @param code: 验证码 eg: "123456"
 * @param password: 密码 eg: "MySecurePassword123"
 * @param confirmPassword: 确认密码 eg: "MySecurePassword123"
 */
public record RegisterReqVO(String account, Integer code, String password, String confirmPassword) {
}
