package com.dcrtv.dcrtvbackend.service;

import com.dcrtv.dcrtvbackend.tool.ApiResult;

public interface VerifyCodeSend {

    public ApiResult code(String number);

}
