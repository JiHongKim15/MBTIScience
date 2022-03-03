package com.mbti.user.user.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {

    private String id;
    private String pw;
    private String mbti;
    private String email;
    private String name;
    private Date lastAccessDate;
    private Date initDate;

}
