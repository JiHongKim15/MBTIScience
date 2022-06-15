package com.mbti.user.user.entity;


import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.dto.UserEmailDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEmailMapper {
    UserEmailDto toUserEmailDto(UserEmailEntity userEmailEntity);
    UserEmailEntity toUserEmailEntity(UserEmailDto userEmailDto);
}
