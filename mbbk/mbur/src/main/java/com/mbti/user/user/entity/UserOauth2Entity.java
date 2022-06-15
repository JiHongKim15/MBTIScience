package com.mbti.user.user.entity;

import com.mbti.user.user.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "user")
public class UserOauth2Entity {

    @Id
    private String email;

    @Column
    private String uuid;

    @Column
    private String name;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @Builder
    public UserOauth2Entity(String name, String picture, Role role) {
        this.name = name;
        this.picture = picture;
        this.role = role;
    }

    public UserOauth2Entity update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

}





