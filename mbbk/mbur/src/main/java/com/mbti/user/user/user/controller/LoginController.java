package com.mbti.user.user.user.controller;

import com.mbti.user.user.user.entity.SessionUser;
import com.mbti.user.user.user.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Valid
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public record LoginController(LoginService loginService) {

    @GetMapping
    public void login(@LoginUser SessionUser user) {
        loginService.login(user);
    }
}
