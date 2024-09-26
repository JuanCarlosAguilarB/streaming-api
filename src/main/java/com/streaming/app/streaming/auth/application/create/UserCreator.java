package com.streaming.app.streaming.auth.application.create;

import com.streaming.app.streaming.auth.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserCreator {

    private final UserRepository repository;
    private final SecurityService securityService;


    public void createUser(UserUserId id, UserEmail email,  UserPassword password) {

        ensureEmailWasNotRegistered(email);

        String rawPassword = password.value();
        UserPassword passwordEncoded = new UserPassword(securityService.encode(rawPassword));

        User user = new User(id, email, passwordEncoded);

        repository.save(user);
    }

    private void ensureEmailWasNotRegistered(UserEmail email) {

        boolean isEmailRegistered = repository.existsByEmail(email);

         if (isEmailRegistered) {
            throw new DuplicateEmailException("The email " + email + " is already registered. Please use a different email.");
        }
    }

}