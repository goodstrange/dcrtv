package com.dcrtv.dcrtvbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthenticationController {

    @GetMapping("/captcha")
    public String captcha() {
        return "Hello, World!";
    }

    @GetMapping("/code/send")
    public String code(String number) {
        return "Service is running";
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
