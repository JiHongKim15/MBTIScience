package com.mbti.user.user.user.controller;


import com.mbti.user.user.user.entity.User;
import com.mbti.user.user.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public User retrieveUserById(@RequestParam String id){
        return userService.retrieveUserById(id);
    }


}
