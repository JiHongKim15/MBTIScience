package com.mbti.chat.mbct.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbti.chat.mbct.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatSubscriber implements MessageListener {

    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;  //redis 서버의 채널로 메시지 전송
    //private final SimpMessageSendingOperations messagingTemplate; //websocket path로 메시지 전송

    @Override
    public void onMessage(Message message, byte[] pattern){
        try{
            String pubMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            ChatMessage chatMessage = objectMapper.readValue(pubMessage, ChatMessage.class);
            System.out.println(chatMessage.toString());
            redisTemplate.convertAndSend("/chat/sub-message", chatMessage);
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }
}
