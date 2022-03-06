package com.mbti.chat.mbct.publisher;

import com.mbti.chat.mbct.domain.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic topic, ChatMessage message){
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
