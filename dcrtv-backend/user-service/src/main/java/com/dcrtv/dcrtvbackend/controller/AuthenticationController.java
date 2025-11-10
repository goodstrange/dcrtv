package com.dcrtv.dcrtvbackend.controller;

import com.dcrtv.dcrtvbackend.service.VerifyCodeSend;
import com.dcrtv.dcrtvbackend.service.impl.VerifyCodeSendImpl;
import com.dcrtv.dcrtvbackend.tool.ApiResult;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/user")
public class AuthenticationController {

    @GetMapping("/captcha")
    public String captcha() {
        return "Hello, World!";
    }

    @GetMapping("/code/send")
    public ApiResult code(@NotBlank(message = "手机号或邮箱不能为空") String number) {
        VerifyCodeSend verifyCodeSend = new VerifyCodeSendImpl();
        ApiResult code = verifyCodeSend.code(number);
        return code;
    }

    @GetMapping("/register")
    public String register() {
        return "Hello, World!";
    }

    @GetMapping("/login/password")
    public String password() {
        return "Hello, World!";
    }

    @GetMapping("/login/verification`")
    public String verify() {
        return "Service is running";
    }
}
