package com.mbti.chat.mbct.domain;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
public class ChatRoom {
    Long chatRoomId;
    Long hostId;
    String mbti;
    Boolean mbtiCheck;
    Integer maxNum;
    LocalDateTime creationTime;
    Integer num;
    String chatSubject;
}
