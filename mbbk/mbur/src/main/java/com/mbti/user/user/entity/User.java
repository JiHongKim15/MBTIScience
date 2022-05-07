package com.mbti.user.user.entity;

import com.mbti.user.user.dto.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String email;

    @Column
    private String id;

    @Column
    private String pw;

    @Column
    private String name;

    @Column
    private String picture;

    @Column
    private String mbti;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Date lastAccessDate;

    @Column(nullable = false)
    private Date firstAccessDate;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    @Builder
    public User(String id, String pw, String name, String email, String picture, Role role) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}





