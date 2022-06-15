package com.mbti.user.client;

import com.mbti.user.user.entity.UserOauth2Entity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//로컬로 변경하기
@FeignClient(name = "user", url = "https://user.custommdomain.co.kr")
public interface UserClient {
    @GetMapping(value = "/api/user")
    UserOauth2Entity getUser();
}
