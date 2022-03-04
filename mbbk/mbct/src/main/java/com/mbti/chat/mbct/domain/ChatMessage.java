package com.mbti.chat.mbct.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage{
    Long messageId;
    Long chatRoomId;
    String message;
    String messageTime;
    Long userId;
}
