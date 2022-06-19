package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.dto.UserDto.UserDtoBuilder;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T09:14:37+0900",
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
        userDto.mbti( userEmailEntity.getMbti() );
        userDto.lastAccessDate( userEmailEntity.getLastAccessDate() );
        userDto.firstAccessDate( userEmailEntity.getFirstAccessDate() );

        return userDto.build();
    }

    @Override
    public UserEntity toUserEntity(UserDto userEmailDto) {
        if ( userEmailDto == null ) {
            return null;
        }

        String uuid = null;
        String mbti = null;
        Date lastAccessDate = null;
        Date firstAccessDate = null;

        uuid = userEmailDto.getUuid();
        mbti = userEmailDto.getMbti();
        lastAccessDate = userEmailDto.getLastAccessDate();
        firstAccessDate = userEmailDto.getFirstAccessDate();

        UserEntity userEntity = new UserEntity( uuid, mbti, lastAccessDate, firstAccessDate );

        return userEntity;
    }
}
