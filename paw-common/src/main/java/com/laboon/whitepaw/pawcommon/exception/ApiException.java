package com.laboon.whitepaw.pawcommon.exception;

import org.slf4j.helpers.MessageFormatter;

public class ApiException extends Exception {
    private String errorCode;

    public ApiException() {
        this.errorCode = null;
    }

    public ApiException(String message) {
        super(message);
        this.errorCode = null;
    }

    public ApiException(String messagePattern, Object... args) {
        super(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
        this.errorCode = null;
    }

    public ApiException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApiException(String errorCode, String messagePattern, Object... args) {
        super(MessageFormatter.arrayFormat(messagePattern, args).getMessage());
        this.errorCode = errorCode;
    }

}
