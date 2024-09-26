package com.streaming.app.streaming.auth.application.find;


import com.streaming.app.streaming.auth.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserFinder {

    private final UserRepository repository;

    public User findById(UserUserId userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("user not found with id: " + userId.value()));
    }

    public User findByEmail(UserEmail email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user not found with email: " + email.value()));
    }

}
