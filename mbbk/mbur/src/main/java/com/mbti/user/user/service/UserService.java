package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.dto.OAuthAttributes;
import com.mbti.user.user.dto.UserOauth2Dto;;
import com.mbti.user.user.entity.UserMapper;
import com.mbti.user.user.entity.UserOauth2Entity;
import com.mbti.user.user.entity.UserOauth2Mapper;
import com.mbti.user.user.repository.UserOauth2Repository;
import com.mbti.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService{

    private final UserOauth2Repository userOauth2Repository;
    private final UserOauth2Mapper userOauth2Mapper;

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    /**
     * Uuid로 User 정보를 가져온다.
     * @param uuid
     * @return
     */
    @Transactional(readOnly = true)
    public List<UserOauth2Dto> retrieveUserByUuid(String uuid){
        return userOauth2Mapper.toUserOauth2DtoList(userOauth2Repository.findAllByUuid(uuid));
    }

    public void saveUserOuath2(OAuthAttributes attributes, String uuid){
        userOauth2Repository.save(userOauth2Mapper.toUserOauth2Entity(UserOauth2Dto.builder()
                .email(attributes.getEmail())
                .uuid(uuid)
                .build()
        ));
    }

    /**
     * User Mbti 정보를 업데이트 한다.
     * @param  userOauth2Entity
     * @return
     */
    public UserOauth2Entity updateUserMbti(UserOauth2Entity userOauth2Entity) {
        UserOauth2Entity user = userOauth2Repository.save(userOauth2Entity);
        return user;
    }

    /**
     * Email로 uuid 조회
     * @param email
     * @return
     */
    @Transactional(readOnly = true)
    public String retrieveUserEmailUUIDByEmail(String email){
        return userOauth2Mapper.toUserOauth2Dto(userOauth2Repository.findByEmail(email).get()).getUuid();
    }

    /**
     * user 정보를 업데이트 한다.
     * @param attributes
     * @return
     */
    public UserOauth2Dto updateUser(OAuthAttributes attributes) {
        UserOauth2Entity userOauth2Entity = userOauth2Repository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userOauth2Mapper.toUserOauth2Dto(userOauth2Repository.save(userOauth2Entity));

    }
}
