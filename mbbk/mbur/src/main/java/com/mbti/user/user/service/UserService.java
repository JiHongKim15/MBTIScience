package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.entity.UserMapper;
import com.mbti.user.user.repository.UserRepository;
import com.mbti.user.user.entity.User;
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
    public User retrieveUserByEmail(String email){
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("사용자 정보를 가져오는 도중 오류가 발생하였습니다.")));
        return user.get();
    }

    /**
     * User Mbti 정보를 업데이트 한다.
     * @param  user
     * @return
     */
    public User updateUserMbti(User user) {
        userRepository.save(user);
        return user;
    }
}
