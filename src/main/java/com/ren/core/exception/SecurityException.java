package com.ren.core.exception;


import com.ren.core.api.IResultCode;
import com.ren.core.api.ResultCode;
import lombok.Getter;

import java.io.Serial;

/**
 * 安全异常
 *
 * @author R
 */
public class SecurityException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    @Getter
    private final IResultCode resultCode;

    public SecurityException(String message) {
        super(message);
        this.resultCode = ResultCode.UN_AUTHORIZED;
    }

    public SecurityException(IResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public SecurityException(IResultCode resultCode, Throwable cause) {
        super(cause);
        this.resultCode = resultCode;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}