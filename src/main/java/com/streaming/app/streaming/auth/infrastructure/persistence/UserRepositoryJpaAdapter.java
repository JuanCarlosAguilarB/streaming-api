package com.streaming.app.streaming.auth.infrastructure.persistence;


import com.streaming.app.streaming.auth.domain.User;
import com.streaming.app.streaming.auth.domain.UserEmail;
import com.streaming.app.streaming.auth.domain.UserRepository;
import com.streaming.app.streaming.auth.domain.UserUserId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.Optional;

import static com.streaming.app.streaming.auth.infrastructure.persistence.UserMapper.toEntity;

@Repository
@AllArgsConstructor
public class UserRepositoryJpaAdapter implements UserRepository {

    private final UserRepositoryJpa repository;


    @Override
    public void save(User user) {
        repository.save(toEntity(user));
    }

    @Override
    public boolean existsByEmail(UserEmail email) {
        return repository.existsByEmail(email.value());
    }

    @Override
    public Optional<User> findByEmail(UserEmail email) {
        return repository.findByEmail(email.value()).map(UserMapper::toDomain);
    }

    @Override
    public Optional<User> findById(UserUserId userId) {
        return repository.findById(userId.value())
                .map(UserMapper::toDomain);
    }

}
