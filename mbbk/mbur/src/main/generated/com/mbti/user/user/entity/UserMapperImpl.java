package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.dto.UserDto.UserDtoBuilder;
import com.mbti.user.user.entity.UserEntity.UserEntityBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T00:38:20+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.email( userEntity.getEmail() );
        userDto.id( userEntity.getId() );
        userDto.pw( userEntity.getPw() );
        userDto.name( userEntity.getName() );
        userDto.picture( userEntity.getPicture() );
        userDto.mbti( userEntity.getMbti() );
        userDto.role( userEntity.getRole() );
        userDto.lastAccessDate( userEntity.getLastAccessDate() );
        userDto.firstAccessDate( userEntity.getFirstAccessDate() );

        return userDto.build();
    }

    @Override
    public UserEntity toUserEntity(UserDto UserDto) {
        if ( UserDto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.name( UserDto.getName() );
        userEntity.email( UserDto.getEmail() );
        userEntity.picture( UserDto.getPicture() );
        userEntity.role( UserDto.getRole() );
        userEntity.id( UserDto.getId() );
        userEntity.pw( UserDto.getPw() );

        return userEntity.build();
    }
}
