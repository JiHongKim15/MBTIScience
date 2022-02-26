package com.mbti.chat.mbct.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessage {
    Long messageId;
    Long chatRoomId;
    String message;
    LocalDateTime messageTime;
    Long userId;
}
