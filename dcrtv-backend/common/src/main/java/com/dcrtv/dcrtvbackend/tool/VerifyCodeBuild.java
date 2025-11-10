package com.dcrtv.dcrtvbackend.tool;

import java.security.SecureRandom;

public class VerifyCodeBuild {

    /**
     * 生成4位数字安全验证码
     * @return
     */
    public static String buildCode(){
        SecureRandom secureRandom =new SecureRandom();
        StringBuilder code= new StringBuilder();
        for (int i=0;i<4;i++){
            code.append(secureRandom.nextInt(10));
        }

        return code.toString();
    }


}
