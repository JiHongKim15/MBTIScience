package com.mbti.user.user.controller;

import com.mbti.user.config.auth.LoginUser;
import com.mbti.user.user.dto.SessionUser;
import com.mbti.user.user.service.LoginService;
import com.mysql.cj.Session;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Valid
@RestController
@RequestMapping("/login")
public record LoginController(LoginService loginService) {

    @GetMapping
    public void login(@LoginUser SessionUser user){
        loginService.login(user);
    }

    @GetMapping("/logout")
    public void logout(@LoginUser SessionUser user){
        loginService.logout(user);
    }
}
