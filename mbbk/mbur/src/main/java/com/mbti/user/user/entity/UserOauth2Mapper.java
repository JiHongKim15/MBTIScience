package com.mbti.user.user.entity;


import com.mbti.user.user.dto.UserOauth2Dto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserOauth2Mapper {

    UserOauth2Dto toUserOauth2Dto(UserOauth2Entity userEntity);
    UserOauth2Entity toUserOauth2Entity(UserOauth2Dto UserDto);

    List<UserOauth2Dto> toUserOauth2DtoList(List<UserOauth2Entity> userEntityList);
    List<UserOauth2Entity> toUserOauth2EntityList(List<UserOauth2Dto> userDtoList);
}
