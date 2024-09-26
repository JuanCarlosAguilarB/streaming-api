package com.streaming.app.streaming.auth.domain;


import java.util.Optional;

public interface UserRepository {

    public void save(User user);

    public boolean existsByEmail(UserEmail email);

    public Optional<User> findByEmail(UserEmail email);

    public Optional<User> findById(UserUserId userId);
}
