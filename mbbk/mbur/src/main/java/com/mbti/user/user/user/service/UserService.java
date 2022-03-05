package com.mbti.user.user.user.service;

import com.mbti.user.user.user.entity.User;
import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    public User retrieveUserById(String id){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new BusinessException("사용자 정보를 가져오는 도중 오류가 발생하였습니다."));
        return user;
    }

    public void saveUser(User user) {
        User confirmUser = userRepository.save(user);
    }

    public void updateUser(User user) {
        User confirmUser = userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
