package com.mbti.chat.mbct.service;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.domain.ChatRoom;
import com.mbti.chat.mbct.exception.ChatException;
import com.mbti.chat.mbct.publisher.ChatPublisher;
import com.mbti.chat.mbct.repository.ChatRepository;
import com.mbti.chat.mbct.subscriber.ChatSubscriber;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatPublisher chatPublisher;
    private final ChatSubscriber chatSubscriber;
    private final RedisMessageListenerContainer redisMessageListenerContainer;

    public ChatRoom createChatRoom(ChatRoom chatRoom){
        return chatRepository.insertChatRoom(chatRoom);
    }
    public void enterChatRoom(Long chatRoomId){
        ChannelTopic topic = chatRepository.getTopic(chatRoomId);
        if(topic == null){
            throw new ChatException("해당 roomId에 대한 방이 존재하지 않습니다.");
        }
        redisMessageListenerContainer.addMessageListener(chatSubscriber, topic);
        chatRepository.insertTopic(chatRoomId, topic);
    }
    public void sendMessage(ChatMessage message){
        chatPublisher.publish(chatRepository.getTopic(message.getChatRoomId()), message);
    }
    public List<ChatRoom> retrieveChatRoomList(){
        return chatRepository.findAllRoom();
    }
    public ChatRoom findRoom(long chatRoomId){
        return chatRepository.findRoomById(chatRoomId);
    }
    public ChatMessage saveChatMessage(ChatMessage chatMessage){
        return chatRepository.insertChatMessage(chatMessage);
    }
    public ChatMessage getChatMessage(Long chatMessageId){
        return chatRepository.getChatMessage(chatMessageId);
    }

}
