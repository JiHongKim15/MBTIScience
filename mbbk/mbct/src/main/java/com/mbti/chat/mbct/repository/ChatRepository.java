package com.mbti.chat.mbct.repository;

import com.mbti.chat.mbct.domain.ChatMessage;
import com.mbti.chat.mbct.domain.ChatRoom;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ChatRepository {

    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private static final String CHAT_MESSAGE = "CHAT_MESSAGE";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, ChatRoom> opsHashChatRoom;
    private HashOperations<String, Long, ChatMessage> opsHashChatMessage;
    private Map<Long, ChannelTopic> topicMap;

    @PostConstruct
    private void initialize(){
        opsHashChatRoom = redisTemplate.opsForHash();
        opsHashChatMessage = redisTemplate.opsForHash();
        topicMap = new HashMap<>();
    }

    public List<ChatRoom> findAllRoom(){
        return opsHashChatRoom.values(CHAT_ROOMS);
    }
    public ChatRoom findRoomById(Long id){
        return opsHashChatRoom.get(CHAT_ROOMS, id);
    }
    /*
    * 채팅방 생성 할 때 redis hash에 채팅방 저장
    */
    public ChatRoom insertChatRoom(ChatRoom chatRoom){
        opsHashChatRoom.put(CHAT_ROOMS, chatRoom.getChatRoomId(), chatRoom);
        return chatRoom;
    }
    /*
     * 발행 후 정상 sub 된 메시지 저장
     */
    public ChatMessage insertChatMessage(ChatMessage chatMessage){
        opsHashChatMessage.put(CHAT_MESSAGE, chatMessage.getMessageId(), chatMessage);
        return chatMessage;
    }
    /*
     * 저장된 메시지 중 특정 메시지 get
     */
    public ChatMessage getChatMessage(Long chatMessageId){
        return opsHashChatMessage.get(CHAT_MESSAGE, chatMessageId);
    }
    public ChannelTopic getTopic(Long chatRoomId){
        return topicMap.get(chatRoomId);
    }
    public void insertTopic(Long chatRoomId, ChannelTopic topic){
        topicMap.put(chatRoomId, topic);
    }


}
