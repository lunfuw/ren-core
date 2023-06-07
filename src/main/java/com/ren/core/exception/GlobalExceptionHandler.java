package com.ren.core.exception;

import com.ren.core.api.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 全局异常拦截
 * @author R
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public <T> Result<T> errorHandler(BaseException exception) {
        return Result.fail(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public <T> Result<T> errorHandler(BizException exception) {
        return Result.fail(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public <T> Result<T> errorHandler(Exception exception) {
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public <T> Result<T> errorHandler(Throwable exception) {
        return Result.fail(exception.getMessage());
    }

    @ExceptionHandler(value = SecurityException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public <T> Result<T> errorHandler(SecurityException exception) {
        return Result.fail(exception.getResultCode(), "没有对应授权");
    }
}