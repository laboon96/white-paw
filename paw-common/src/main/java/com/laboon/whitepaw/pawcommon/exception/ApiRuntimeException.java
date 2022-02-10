package com.laboon.whitepaw.pawcommon.exception;


import org.slf4j.helpers.MessageFormatter;

public class ApiRuntimeException extends RuntimeException {
    protected final String errorCode;
    protected final ApiRuntimeException exception;

    public ApiRuntimeException() {
        this.errorCode = "";
        this.exception = null;
    }

    public ApiRuntimeException(String errorCode) {
        this.errorCode = errorCode;
        this.exception = null;
    }

    public ApiRuntimeException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.exception = null;
    }

    public ApiRuntimeException(String errorCode, String messagePattern, Object... args) {
        super(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
        this.errorCode = errorCode;
        this.exception = null;
    }

    public ApiRuntimeException(String errorCode, ApiRuntimeException exception, String message) {
        super(message);
        this.errorCode = errorCode;
        this.exception = exception;
    }

    public ApiRuntimeException(String errorCode, ApiRuntimeException exception, String messagePattern, Object... args) {
        super(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
        this.errorCode = errorCode;
        this.exception = exception;
    }
}
