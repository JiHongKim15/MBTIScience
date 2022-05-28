package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.entity.UserEntity;
import com.mbti.user.user.entity.UserMapper;
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
    private final UserMapper userMapper;

    /**
     * Email 정보로 User 정보를 리턴한다.
     * @param email
     * @return
     */
    @Transactional(readOnly = true)
    public UserDto retrieveUserByEmail(String email){

        //Optional은 JPA 권장사항이므로 JPA에서 가져올 때 사용하고 이후 사용하지 않는다.
        //WHY? 비용이 비싸기 때문
        UserDto user = userMapper.toUserDto(Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("사용자 정보를 가져오는 도중 오류가 발생하였습니다.")))
                .get());

        return user;
    }

    /**
     * User Mbti 정보를 업데이트 한다.
     * @param  userEntity
     * @return
     */
    public UserEntity updateUserMbti(UserEntity userEntity) {
        UserEntity user = userRepository.save(userEntity);
        return user;
    }
}
