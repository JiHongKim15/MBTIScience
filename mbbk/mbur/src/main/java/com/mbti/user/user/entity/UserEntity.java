package com.mbti.user.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@AllArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    private String uuid;

    @Column
    private String mbti;

    @Column(nullable = false)
    private Date lastAccessDate;

    @Column(nullable = false)
    private Date firstAccessDate;

}





