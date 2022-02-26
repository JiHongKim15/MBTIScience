package com.mbti.chat.mbct.controller;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.publisher.ChatPublisher;
import com.mbti.chat.mbct.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {
    private final ChatPublisher chatPublisher;
    private final ChatService chatService;

    @MessageMapping("/chat/message")    //메시지를 해당 path에 보내도록 설정하는 annotation
    public void message(ChatMessage message){
        chatService.enterChatRoom(message.getChatRoomId());
        message.setMessage(message.getUserId()+"님이 입장하셨습니다.");
        chatPublisher.publish(chatService.getTopic(message.getChatRoomId()), message);
    }
}
