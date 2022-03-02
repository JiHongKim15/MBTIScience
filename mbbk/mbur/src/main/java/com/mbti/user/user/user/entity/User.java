package com.mbti.user.user.user.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String pw;
    private String mbti;
    private String email;
    private String name;
    private Date lastAccessDate;
    private Date firstAccessDate;

}
