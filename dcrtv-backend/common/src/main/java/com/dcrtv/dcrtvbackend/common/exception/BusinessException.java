package com.dcrtv.dcrtvbackend.common.exception;

import com.dcrtv.dcrtvbackend.common.response.RCodeMsgEnum;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException {

    private Integer code;
    private String message;

    public BusinessException(RCodeMsgEnum rCodeMsgEnum) {
        super(rCodeMsgEnum.getMessage());
        this.code = rCodeMsgEnum.getCode();
        this.message = rCodeMsgEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}