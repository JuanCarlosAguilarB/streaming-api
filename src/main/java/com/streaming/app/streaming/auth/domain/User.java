package com.streaming.app.streaming.auth.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    private final UserUserId userId;
    private final UserEmail email;
    private final UserPassword password;

    public UserUserId id() {
        return userId;
    }

    public UserEmail email() {
        return email;
    }

    public UserPassword password() {
        return password;
    }

}
