package com.mbti.board.externalApi.Client;

import com.mbti.board.externalApi.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "userApi",
        url = "http://localhost:8082/user/",
        configuration = userClientConfiguration.class,
        fallback = userClientFallBack.class
)
public interface userClient {

    @GetMapping("retrieveUserById/{id}")
    public UserResponse retrieveUserById(@PathVariable String id);
}
