package com.mbti.user.user.controller;

import com.mbti.user.config.auth.LoginUser;
import com.mbti.user.user.dto.SessionUser;
import com.mbti.user.user.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Valid
@RestController
@RequestMapping("/login")
public record LoginController(LoginService loginService) {

    @GetMapping
    public void login(){
    }

    @GetMapping("/google")
    public void loginGoogle(@LoginUser SessionUser user) {
        loginService.loginGoogle(user);
    }

    @GetMapping("/naver")
    public void loginNaver(@LoginUser SessionUser user) {
        loginService.loginNaver(user);
    }

    @GetMapping("/kakao")
    public void loginKakao(@LoginUser SessionUser user) {
        loginService.loginKakao(user);
    }

    @GetMapping("/logout")
    public void logout(@LoginUser SessionUser user){
        loginService.logout(user);
    }
}
