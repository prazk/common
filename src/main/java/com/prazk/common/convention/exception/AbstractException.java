package com.prazk.common.convention.exception;

import com.prazk.common.convention.errorcode.IErrorCode;

import java.util.Optional;


public abstract class AbstractException extends RuntimeException {
    // 抽象类属性：默认是 public static final 的
    String errorCode;
    String errorMessage;

    public AbstractException(String msg, Throwable throwable, IErrorCode errorCode) {
        super(msg, throwable);
        this.errorCode = errorCode.code();
        // 如果传入的非空，则展示msg，否则展示errorCode的msg
        this.errorMessage = (msg != null && !msg.isEmpty()) ? msg : errorCode.message();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
