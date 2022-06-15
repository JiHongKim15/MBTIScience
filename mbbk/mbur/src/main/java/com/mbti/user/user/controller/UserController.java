package com.mbti.user.user.controller;


import com.mbti.user.user.dto.UserOauth2Dto;
import com.mbti.user.user.entity.UserOauth2Entity;
import com.mbti.user.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Valid
@RestController
@RequestMapping("/user")
public record UserController(UserService userService) {

    @GetMapping("/retrieve")
    public UserOauth2Dto retrieveUserByEmail(@RequestParam String email){
        log.debug("이메일로 유저 정보 확인: " + email);
     //   return userService.retr(email);
        return null;
    }

    @PatchMapping("/updatembti")
    public UserOauth2Entity updateUserMbti(@RequestBody UserOauth2Entity userEntity){
        return userService.updateUserMbti(userEntity);
    }

}
