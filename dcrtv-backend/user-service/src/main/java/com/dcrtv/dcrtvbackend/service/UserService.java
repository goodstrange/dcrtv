package com.dcrtv.dcrtvbackend.service;

import com.dcrtv.dcrtvbackend.tool.ApiResult;

public interface UserService {

    public ApiResult loginVerify(String number,String code);
}
