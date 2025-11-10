package com.dcrtv.dcrtvbackend.tool;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
        log.error("请求异常: URL={}, 异常类型={}, 异常信息={}", request.getRequestURL(), e.getClass().getSimpleName(), e.getMessage(), e);
        return ApiResult.error("服务器异常");
    }
}
