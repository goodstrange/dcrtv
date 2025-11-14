package com.dcrtv.dcrtvbackend.tool;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dcrtv.dcrtvbackend.common.exception.BusinessException;
import com.dcrtv.dcrtvbackend.common.response.R;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class WebExceptionHandler {

    /***
     * 全局异常处理器
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ApiResult exceptionHandler(Exception e, HttpServletRequest request){
        log.error("请求异常: URL={}, 异常类型={}, 异常信息={}", request.getRequestURL(), e.getClass().getSimpleName(), e.getMessage());
        return ApiResult.error(e.getMessage());
    }
    
    /***
     * 业务异常处理器
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public R<Void> businessExceptionHandler(BusinessException e, HttpServletRequest request) {
        log.error("请求异常: URL={}, 错误码={}, 错误信息={}", request.getRequestURL(), e.getCode(), e.getMessage(), e);
        return R.error(e.getCode(), e.getMessage());
    }
}
