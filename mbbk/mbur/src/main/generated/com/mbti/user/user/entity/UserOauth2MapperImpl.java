package com.mbti.user.user.entity;

import com.mbti.user.user.dto.UserOauth2Dto;
import com.mbti.user.user.dto.UserOauth2Dto.UserOauth2DtoBuilder;
import com.mbti.user.user.entity.UserOauth2Entity.UserOauth2EntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-16T09:14:38+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class UserOauth2MapperImpl implements UserOauth2Mapper {

    @Override
    public UserOauth2Dto toUserOauth2Dto(UserOauth2Entity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserOauth2DtoBuilder userOauth2Dto = UserOauth2Dto.builder();

        userOauth2Dto.uuid( userEntity.getUuid() );
        userOauth2Dto.email( userEntity.getEmail() );
        userOauth2Dto.name( userEntity.getName() );
        userOauth2Dto.picture( userEntity.getPicture() );
        userOauth2Dto.role( userEntity.getRole() );

        return userOauth2Dto.build();
    }

    @Override
    public UserOauth2Entity toUserOauth2Entity(UserOauth2Dto UserDto) {
        if ( UserDto == null ) {
            return null;
        }

        UserOauth2EntityBuilder userOauth2Entity = UserOauth2Entity.builder();

        userOauth2Entity.name( UserDto.getName() );
        userOauth2Entity.picture( UserDto.getPicture() );
        userOauth2Entity.role( UserDto.getRole() );

        return userOauth2Entity.build();
    }

    @Override
    public List<UserOauth2Dto> toUserOauth2DtoList(List<UserOauth2Entity> userEntityList) {
        if ( userEntityList == null ) {
            return null;
        }

        List<UserOauth2Dto> list = new ArrayList<UserOauth2Dto>( userEntityList.size() );
        for ( UserOauth2Entity userOauth2Entity : userEntityList ) {
            list.add( toUserOauth2Dto( userOauth2Entity ) );
        }

        return list;
    }

    @Override
    public List<UserOauth2Entity> toUserOauth2EntityList(List<UserOauth2Dto> userDtoList) {
        if ( userDtoList == null ) {
            return null;
        }

        List<UserOauth2Entity> list = new ArrayList<UserOauth2Entity>( userDtoList.size() );
        for ( UserOauth2Dto userOauth2Dto : userDtoList ) {
            list.add( toUserOauth2Entity( userOauth2Dto ) );
        }

        return list;
    }
}
