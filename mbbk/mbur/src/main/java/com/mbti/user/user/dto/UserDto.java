package com.mbti.user.user.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
public class UserDto {

    private String uuid;
    private String name;
    private String picture;
    private String mbti;
    private Role role;
    private Date lastAccessDate;
    private Date firstAccessDate;

    public String getRoleKey() {
        return this.role.getKey();
    }

}
