package com.mbti.board.mainBoard.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
    public BusinessException(String message, Throwable e) {
        super(message, e);
    }
}
