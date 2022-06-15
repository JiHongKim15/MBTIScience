package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserEmailDto;
import com.mbti.user.user.dto.UserEmailDto.UserEmailDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-15T19:29:27+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class UserEmailMapperImpl implements UserEmailMapper {

    @Override
    public UserEmailDto toUserEmailDto(UserEmailEntity userEmailEntity) {
        if ( userEmailEntity == null ) {
            return null;
        }

        UserEmailDtoBuilder userEmailDto = UserEmailDto.builder();

        userEmailDto.uuid( userEmailEntity.getUuid() );
        userEmailDto.email( userEmailEntity.getEmail() );

        return userEmailDto.build();
    }

    @Override
    public UserEmailEntity toUserEmailEntity(UserEmailDto userEmailDto) {
        if ( userEmailDto == null ) {
            return null;
        }

        String email = null;
        String uuid = null;

        email = userEmailDto.getEmail();
        uuid = userEmailDto.getUuid();

        UserEmailEntity userEmailEntity = new UserEmailEntity( email, uuid );

        return userEmailEntity;
    }
}
