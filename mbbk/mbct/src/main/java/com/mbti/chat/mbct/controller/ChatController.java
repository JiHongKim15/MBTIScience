package com.mbti.chat.mbct.controller;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.domain.ChatRoom;
import com.mbti.chat.mbct.publisher.ChatPublisher;
import com.mbti.chat.mbct.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatPublisher chatPublisher;
    private final ChatService chatService;

    @MessageMapping("/chat/message")    //메시지를 해당 path에 보내도록 설정하는 annotation
    public void sendMessage(ChatMessage message){
        chatService.enterChatRoom(message.getChatRoomId());
        message.setMessage(message.getUserId()+"님이 입장하셨습니다.");
        chatPublisher.publish(chatService.getTopic(message.getChatRoomId()), message);
    }
    @PostMapping("/chat/chat-room")
    public ChatRoom createChatRoom(ChatRoom chatRoom){
        return chatService.createChatRoom(chatRoom);
    }
    @ResponseBody
    @GetMapping("/chat/rooms")
    public List<ChatRoom> retrieveChatRoomList(){
        return chatService.retrieveChatRoomList();
    }
    @ResponseBody
    @GetMapping("/chat/rooms/{id}")
    public ChatRoom findRoom(@PathVariable Long chatRoomId){
        return chatService.findRoom(chatRoomId);
    }
    @GetMapping("/chat/enter/{id}")
    public void enterChatRoom(@PathVariable Long id){
        chatService.enterChatRoom(id);
    }
}
