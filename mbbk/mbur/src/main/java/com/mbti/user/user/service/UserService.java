package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.entity.UserEntity;
import com.mbti.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    /**
     * Email 정보로 User 정보를 리턴한다.
     * @param email
     * @return
     */
    @Transactional(readOnly = true)
    public UserEntity retrieveUserByEmail(String email){
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("사용자 정보를 가져오는 도중 오류가 발생하였습니다.")));
        return user.get();
    }

    /**
     * User Mbti 정보를 업데이트 한다.
     * @param  userEntity
     * @return
     */
    public UserEntity updateUserMbti(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }
}
