package com.mbti.user.user.user.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, Throwable e) {
        super(message, e);
    }
}
