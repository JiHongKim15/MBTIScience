package com.mbti.chat.mbct.exception;

public class ChatException extends RuntimeException{

    public ChatException(String message){
        super(message);
    }
    public ChatException(String message, Throwable e){
        super(message, e);
    }
}
