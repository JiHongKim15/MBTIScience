package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.dto.UserDto.UserDtoBuilder;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-15T21:56:49+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(UserEntity userEmailEntity) {
        if ( userEmailEntity == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.uuid( userEmailEntity.getUuid() );
        userDto.email( userEmailEntity.getEmail() );
        userDto.lastAccessDate( userEmailEntity.getLastAccessDate() );
        userDto.firstAccessDate( userEmailEntity.getFirstAccessDate() );

        return userDto.build();
    }

    @Override
    public UserEntity toUserEntity(UserDto userEmailDto) {
        if ( userEmailDto == null ) {
            return null;
        }

        String email = null;
        String uuid = null;
        Date lastAccessDate = null;
        Date firstAccessDate = null;

        email = userEmailDto.getEmail();
        uuid = userEmailDto.getUuid();
        lastAccessDate = userEmailDto.getLastAccessDate();
        firstAccessDate = userEmailDto.getFirstAccessDate();

        String mbti = null;

        UserEntity userEntity = new UserEntity( email, uuid, mbti, lastAccessDate, firstAccessDate );

        return userEntity;
    }
}
