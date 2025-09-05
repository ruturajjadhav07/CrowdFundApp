package com.crowdfunding.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crowdfunding.backend.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    // check existing email
    Boolean existsByEmail(String email);

    // check existing username
    Boolean existsByUsername(String username);
}
