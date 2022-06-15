package com.mbti.user.user.entity;


import com.mbti.user.user.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(UserEntity userEntity);
    UserEntity toUserEntity(UserDto UserDto);
}
