package com.mbti.board.externalApi.Client;

import com.mbti.board.mainBoard.exception.ExternalApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

@Slf4j
public class userClientFallBack implements FallbackFactory<userClient> {
    @Override
    public userClient create(Throwable cause) {
        log.error("유저 API 호출에 실패하였습니다. case: " + cause.getMessage());
        throw new ExternalApiException("유저 서버와의 통신에 실패했습니다.");
    }

}
