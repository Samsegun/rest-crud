package com.samsegun.restdemo.dao;

import com.samsegun.restdemo.BaseException;

public class EntityException extends BaseException {
    private final String errorCode;
    public EntityException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
