package com.dcrtv.dcrtvbackend.service;

import com.dcrtv.dcrtvbackend.tool.ApiResult;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService {

    public ApiResult loginVerify(String number, String code, HttpServletResponse response);
}
