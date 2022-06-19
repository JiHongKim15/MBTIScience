package com.mbti.user.user.dto;

import lombok.Getter;

import java.io.Serializable;

/**
 * 직렬화 기능을 가진 User클래스
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserOauth2Dto userDto){
        this.name = userDto.getName();
//        this.email = userDto.getEmail();
        this.picture = userDto.getPicture();
    }
}