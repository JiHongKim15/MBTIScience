package com.mbti.chat.mbct.service;

import com.mbti.chat.mbct.domain.ChatRoom;
import com.mbti.chat.mbct.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatRoom createChatRoom(ChatRoom chatRoom){
        return chatRepository.insert(chatRoom);
    }
    public void enterChatRoom(Long chatRoomId){
        chatRepository.enter(chatRoomId);
    }
    public ChannelTopic getTopic(Long chatRoomId){
        return chatRepository.getTopic(chatRoomId);
    }

}
