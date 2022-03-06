package com.mbti.chat.mbct.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom implements Serializable {
    Long chatRoomId;
    Long hostId;
    String mbti;
    Boolean mbtiCheck;
    Integer maxNum;
    LocalDateTime creationTime;
    Integer num;
    String chatSubject;
}
