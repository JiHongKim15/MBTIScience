package com.mbti.user.client;

import com.mbti.user.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//url을 어떻게 하는 것이 좋을 까?
@FeignClient(name = "user", url = "https://user.custommdomain.co.kr")
public interface UserClient {
    @GetMapping(value = "/api/user")
    User getUser();
}
