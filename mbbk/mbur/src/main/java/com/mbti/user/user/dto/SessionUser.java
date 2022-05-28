package com.mbti.user.user.dto;

import com.mbti.user.user.entity.UserEntity;
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

    public SessionUser(UserEntity userEntity){
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.picture = userEntity.getPicture();
    }
}