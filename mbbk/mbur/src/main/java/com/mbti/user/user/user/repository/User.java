package com.mbti.user.user.user.repository;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private String id;
    private String pw;
    private String email;
    private String name;
    private String mbti;
    private Date lastAccessDate;
    private Date initDate;

}
