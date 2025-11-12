package com.dcrtv.dcrtvbackend.common.enums;

import org.springframework.stereotype.Component;

import com.dcrtv.dcrtvbackend.common.response.RCodeMsgEnum;

@Component
public enum CommonExceptionEnums implements RCodeMsgEnum {
    PARAMETER_ERROR(400, "参数错误");

    private Integer code;
    private String message;

    private CommonExceptionEnums(Integer code, String message) {
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
