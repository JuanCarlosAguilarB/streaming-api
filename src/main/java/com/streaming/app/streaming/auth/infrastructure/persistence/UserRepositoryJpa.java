package com.streaming.app.streaming.auth.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface UserRepositoryJpa extends JpaRepository<UserEntity, UUID> {

    public boolean existsByEmail(String email);
    public Optional<UserEntity> findByEmail(String email);

}
