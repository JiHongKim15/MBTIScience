package com.mbti.chat.mbct.dto;

import java.time.LocalDateTime;

public class ChatMessageDTO {
    Long messageId;
    Long chatRoomId;
    String message;
    LocalDateTime messageTime;
    Long userId;
}
