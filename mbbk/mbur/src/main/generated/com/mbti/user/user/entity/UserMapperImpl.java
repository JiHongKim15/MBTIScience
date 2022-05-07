package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.dto.UserDto.UserDtoBuilder;
import com.mbti.user.user.entity.User.UserBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-08T02:59:30+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.email( user.getEmail() );
        userDto.id( user.getId() );
        userDto.pw( user.getPw() );
        userDto.name( user.getName() );
        userDto.picture( user.getPicture() );
        userDto.mbti( user.getMbti() );
        userDto.role( user.getRole() );
        userDto.lastAccessDate( user.getLastAccessDate() );
        userDto.firstAccessDate( user.getFirstAccessDate() );

        return userDto.build();
    }

    @Override
    public User toUserEntity(UserDto UserDto) {
        if ( UserDto == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        user.name( UserDto.getName() );
        user.email( UserDto.getEmail() );
        user.picture( UserDto.getPicture() );
        user.role( UserDto.getRole() );
        user.id( UserDto.getId() );
        user.pw( UserDto.getPw() );

        return user.build();
    }
}
