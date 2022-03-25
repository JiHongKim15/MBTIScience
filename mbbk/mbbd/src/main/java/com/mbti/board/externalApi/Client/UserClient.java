package com.mbti.board.externalApi.Client;

import com.mbti.board.externalApi.response.UserResponse;
import org.springframework.web.reactive.function.client.WebClient;


public class UserClient {
    private static final WebClient webClient = WebClient.create( "http://localhost:8082/user/");

    public boolean retrieveUserById(String id){
        UserResponse userResponse =
            webClient.get()
                .uri("retrieveUserById/{id}", id)
                .retrieve()
                .bodyToMono(UserResponse.class)
                .block();

        if(userResponse != null)
            return userResponse.getId().equals(id);
        else
            return false;
    }



}
