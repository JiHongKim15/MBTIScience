package com.mbti.chat.mbct.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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
