package com.mbti.user.user.repository;

import com.mbti.user.user.entity.UserEmailEntity;
import com.mbti.user.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEmailRepository extends JpaRepository<UserEmailEntity, String> {
    Optional<UserEmailEntity> findByEmail(String email);
}
