package com.mbti.chat.mbct.controller;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.domain.ChatRoom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class ChatControllerTest {

    @Autowired
    private ChatController chatController;

    @Test
    void sendMessage() {

        ChatMessage chatMessage = ChatMessage.builder()
                .messageId(123L)
                .chatRoomId(123L)
                .userId(123L)
                .messageTime(LocalDateTime.now().toString())
                .message("Hi I'm wisdom!")
                .build();

        chatController.sendMessage(chatMessage);
    }

    @Test
    void createChatRoom() {
        ChatRoom chatRoom = ChatRoom.builder()
                .chatRoomId(124L)
                .chatSubject("test room 2")
                .creationTime(LocalDateTime.now())
                .hostId(123L)
                .mbti("ENFP")
                .mbtiCheck(false)
                .maxNum(8)
                .build();
        chatController.createChatRoom(chatRoom);

        ChatRoom found = chatController.findRoom(124L);

        assertEquals(chatRoom.getChatSubject(), found.getChatSubject());
    }

    @Test
    void retrieveChatRoomList() {
        List<ChatRoom> rooms = chatController.retrieveChatRoomList();

        assertNotEquals(rooms.size(), 0);
    }
}