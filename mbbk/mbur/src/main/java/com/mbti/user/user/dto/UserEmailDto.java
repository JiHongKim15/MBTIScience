package com.mbti.user.user.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserEmailDto {

    private String uuid;
    private String email;

}
