package com.mbti.chat.mbct.repository;

import com.mbti.chat.mbct.domain.ChatRoom;
import com.mbti.chat.mbct.subscriber.ChatSubscriber;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Repository
public class ChatRepository {

    private final RedisMessageListenerContainer redisMessageListenerContainer;
    private final ChatSubscriber chatSubscriber;
    private static final String CHAT_ROOMS = "CHAT_ROOM";
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, Long, ChatRoom> opsHashChatRoom;
    private Map<Long, ChannelTopic> topicMap;

    @PostConstruct
    private void initialize(){
        opsHashChatRoom = redisTemplate.opsForHash();
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
    public ChatRoom insert(ChatRoom chatRoom){
        opsHashChatRoom.put(CHAT_ROOMS, chatRoom.getChatRoomId(), chatRoom);
        return chatRoom;
    }
    /*
     * 채팅방에 입장할 때 pub/sub을 위해 listener 설정
     */
    public void enter(Long chatRoomId){
        ChannelTopic topic = topicMap.get(chatRoomId);
        if(topic == null){
            topic = new ChannelTopic(chatRoomId.toString());
            redisMessageListenerContainer.addMessageListener(chatSubscriber, topic);
            topicMap.put(chatRoomId, topic);
        }
    }
    public ChannelTopic getTopic(Long chatRoomId){
        return topicMap.get(chatRoomId);
    }


}
