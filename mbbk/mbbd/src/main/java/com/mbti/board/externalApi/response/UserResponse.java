package com.mbti.board.externalApi.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class UserResponse {

    private String email;
    private String id;
    private String pw;
    private String name;
    private String picture;
    private String mbti;
    private Role role;
    private Date lastAccessDate;
    private Date firstAccessDate;

    @Getter
    @RequiredArgsConstructor
    public enum Role {
        GUEST("ROLE_GUEST", "손님"),
        USER("ROLE_USER", "일반 사용자");

        private final String key;
        private final String title;

    }
}
