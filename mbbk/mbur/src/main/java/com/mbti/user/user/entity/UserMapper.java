package com.mbti.user.user.entity;


import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUserEntity(UserDto UserDto);
}
