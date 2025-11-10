package com.dcrtv.dcrtvbackend;

import com.dcrtv.dcrtvbackend.service.VerifyCodeSend;
import com.dcrtv.dcrtvbackend.tool.ApiResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VerifyCodeSendTest {

    @Autowired
    private VerifyCodeSend verifyCodeSend;

    @Test
    void testCodeSend() {
        ApiResult result = verifyCodeSend.code("18890612345");
        System.out.println("测试结果: " + result);
    }
}