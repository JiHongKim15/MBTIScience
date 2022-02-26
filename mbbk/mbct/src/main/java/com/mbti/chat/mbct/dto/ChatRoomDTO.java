package com.mbti.chat.mbct.dto;

import java.time.LocalDateTime;

public class ChatRoomDTO {
    Long chatRoomId;
    Long hostId;
    String mbti;
    Boolean mbtiCheck;
    Integer maxNum;
    LocalDateTime creationTime;
    Integer num;
    String chatSubject;
}
