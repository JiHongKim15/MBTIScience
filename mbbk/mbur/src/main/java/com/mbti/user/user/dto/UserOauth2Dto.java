package com.mbti.user.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserOauth2Dto {

    private String uuid;
    private String email;
    private String name;
    private String picture;
    private String mbti;
    private Role role;

    public String getRoleKey() {
        return this.role.getKey();
    }

}
