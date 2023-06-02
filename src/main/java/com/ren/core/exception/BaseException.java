package com.ren.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 全局异常基类
 *
 * @author R
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
    private Integer code;
    private String message;

    public BaseException(String message) {
        this.setCode(500);
        this.setMessage(message);
    }

    public BaseException(Integer code, String msg) {
        this.setCode(code);
        this.setMessage(msg);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}