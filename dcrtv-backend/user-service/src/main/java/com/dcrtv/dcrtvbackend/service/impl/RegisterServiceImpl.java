package com.dcrtv.dcrtvbackend.service.impl;

import org.springframework.data.redis.core.RedisTemplate;

import com.dcrtv.dcrtvbackend.common.enums.CommonExceptionEnums;
import com.dcrtv.dcrtvbackend.common.exception.BusinessException;
import com.dcrtv.dcrtvbackend.common.model.vo.req.RegisterReqVO;
import com.dcrtv.dcrtvbackend.common.model.vo.resp.RegisterRespVO;
import com.dcrtv.dcrtvbackend.enums.AuthenticationEnums;
import com.dcrtv.dcrtvbackend.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

    private final RedisTemplate<String, String> redisTemplate;

    public RegisterServiceImpl(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public RegisterRespVO register(RegisterReqVO registerReqVO) {
        // 1. 验证参数 检查必填字段
        String account = registerReqVO.account();
        Integer rawCode = registerReqVO.code();
        if (registerReqVO == null || account == null || rawCode == null
                || registerReqVO.password() == null || registerReqVO.confirmPassword() == null) {
            throw new BusinessException(CommonExceptionEnums.PARAMETER_ERROR);
        }
        // 2. 验证码校验 根据 account 从缓存中查找对应的验证码进行校验
        String code = (String) redisTemplate.opsForValue().get(account);
        if (code == null || !code.equals(String.valueOf(rawCode))) {
            throw new BusinessException(AuthenticationEnums.VERIFY_ERROR_OR_EXPIRED);
        }
        // TODO 3. 账号唯一性校验 根据 account 在用户表中查询是否已存在
        // 4. 密码一致性校验 检查 password 和 confirm_password 是否一致
        if (!registerReqVO.password().equals(registerReqVO.confirmPassword())) {
            throw new BusinessException(AuthenticationEnums.PASSWORD_NOT_CONSISTENT);
        }
        // TODO 5. 创建用户 校验通过后，创建新用户记录。 account_type 字段来标识是手机号(mobile)还是邮箱(email)
        return null;
    }

}
