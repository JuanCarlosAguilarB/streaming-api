package com.streaming.app.streaming.auth.infrastructure.persistence;


import com.streaming.app.streaming.auth.domain.User;
import com.streaming.app.streaming.auth.domain.UserEmail;
import com.streaming.app.streaming.auth.domain.UserPassword;
import com.streaming.app.streaming.auth.domain.UserUserId;

public class UserMapper {

    public static User toDomain(UserEntity userEntity) {

        return new User(
                new UserUserId(userEntity.getUserId()),
                new UserEmail(userEntity.getEmail()),
                new UserPassword(userEntity.getPassword())
        );
    }

    public static UserEntity toEntity(User user) {

        return UserEntity.builder()
                .userId(user.id().value())
                .email(user.email().value())
                .password(user.password().value())
                .build();
    }
}
