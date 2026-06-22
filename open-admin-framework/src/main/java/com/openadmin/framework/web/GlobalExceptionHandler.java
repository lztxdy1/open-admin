package com.openadmin.framework.web;

import com.openadmin.common.core.ApiResult;
import com.openadmin.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ApiResult<Void> handleBusiness(BusinessException e) { return ApiResult.fail(e.getCode(), e.getMessage()); }

    @ExceptionHandler(Exception.class)
    public ApiResult<Void> handle(Exception e) {
        e.printStackTrace();
        return ApiResult.fail("系统异常：" + e.getMessage());
    }
}
