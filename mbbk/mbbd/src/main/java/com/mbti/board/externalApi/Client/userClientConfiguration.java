package com.mbti.board.externalApi.Client;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

public class userClientConfiguration {

    //TODO 토큰 추가시 해당 값 yaml 추가 및 불러오기
    private final String token = "";

    @Bean
    public RequestInterceptor userApiClientRequestHeader(){
        return requestTemplate -> requestTemplate.header("Authorization", token);
    }
}
