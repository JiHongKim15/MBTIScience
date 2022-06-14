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
@Table(name = "userEmail")
public class UserEmailEntity {

    @Id
    private String email;

    @Column
    private String uuid;

}





