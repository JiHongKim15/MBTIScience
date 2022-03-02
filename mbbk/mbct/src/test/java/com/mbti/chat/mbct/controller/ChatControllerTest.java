package com.mbti.chat.mbct.controller;

import com.mbti.chat.mbct.domain.ChatRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatControllerTest {

    @Autowired
    private ChatController chatController;

    @Test
    void sendMessage() {
    }

    @Test
    void createChatRoom() {
        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomId(123L)
                .chatSubject("test room 1")
                .creationTime(LocalDateTime.now())
                .hostId(123L)
                .mbti("ESTJ")
                .mbtiCheck(false)
                .maxNum(8)
                .build();
        chatController.createChatRoom(chatRoom);

        ChatRoom found = chatController.findRoom(123L);

        assertEquals(chatRoom.getChatSubject(), found.getChatSubject());
    }

    @Test
    void retrieveChatRoomList() {

    }
}