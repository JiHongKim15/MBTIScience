package com.mbti.chat.mbct.controller;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.domain.ChatRoom;
import com.mbti.chat.mbct.publisher.ChatPublisher;
import com.mbti.chat.mbct.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChatController {
    private final ChatPublisher chatPublisher;
    private final ChatService chatService;

    @MessageMapping("/chat/message")    //메시지를 해당 path에 보내도록 설정하는 annotation
    public void sendMessage(ChatMessage message){
        chatService.sendMessage(message);
    }
    @MessageMapping("/chat/sub-message")    //메시지 저장
    public void saveMessage(ChatMessage message){
        chatService.saveChatMessage(message);
    }
    @GetMapping("/chat/messages/{id}")    //메시지 get
    public ChatMessage getMessage(Long messageId){
        return chatService.getChatMessage(messageId);
    }
    @PostMapping("/chat/chat-room")
    public ChatRoom createChatRoom(ChatRoom chatRoom){
        return chatService.createChatRoom(chatRoom);
    }
    @GetMapping("/chat/rooms")
    public List<ChatRoom> retrieveChatRoomList(){
        return chatService.retrieveChatRoomList();
    }
    @GetMapping("/chat/rooms/{chatRoomId}")
    public ChatRoom findRoom(@PathVariable Long chatRoomId){
        return chatService.findRoom(chatRoomId);
    }
    @GetMapping("/chat/enter/{id}")
    public void enterChatRoom(@PathVariable Long id){
        chatService.enterChatRoom(id);
    }
}
