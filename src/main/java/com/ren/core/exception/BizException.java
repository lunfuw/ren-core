package com.ren.core.exception;

/**
 * 业务异常类
 * @author R
 */
public class BizException extends BaseException {
    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String msg) {
        super(code, msg);
    }
}