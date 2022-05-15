package com.mbti.board.mainBoard.exception;

public class ExternalApiException extends RuntimeException {
    public ExternalApiException(String message) {
        super(message);
    }
    public ExternalApiException(String message, Throwable e) {
        super(message, e);
    }
}
