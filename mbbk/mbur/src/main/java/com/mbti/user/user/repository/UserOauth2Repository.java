package com.mbti.user.user.repository;

import com.mbti.user.user.entity.UserOauth2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserOauth2Repository extends JpaRepository<UserOauth2Entity, String> {
    Optional<UserOauth2Entity> findByEmail(String email);
    List<UserOauth2Entity> findAllByUuid(String uuid);
}
