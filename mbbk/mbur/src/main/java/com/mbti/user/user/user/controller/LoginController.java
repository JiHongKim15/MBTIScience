package com.mbti.user.user.user.controller;

import com.mbti.user.user.config.auth.LoginUser;
import com.mbti.user.user.user.dto.SessionUser;
import com.mbti.user.user.user.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Valid
@RestController
@RequestMapping("/login")
public record LoginController(LoginService loginService) {

    @GetMapping
    public void login(){
        System.out.println("TEST!!!!!!!!!");
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
