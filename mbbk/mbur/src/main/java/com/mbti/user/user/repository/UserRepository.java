package com.mbti.user.user.repository;

import com.mbti.user.user.entity.UserEntity;
import com.mbti.user.user.entity.UserOauth2Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUuid(String uuid);
}
