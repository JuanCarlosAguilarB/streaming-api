package com.streaming.app.streaming.auth.infrastructure.controllers;

import com.streaming.app.streaming.auth.application.create.UserCreator;
import com.streaming.app.streaming.auth.domain.UserEmail;
import com.streaming.app.streaming.auth.domain.UserPassword;
import com.streaming.app.streaming.auth.domain.UserUserId;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class AuthPutController {

    private final UserCreator service;

    @Operation(summary = "Sign up a user", description = "Creates a new user", tags = {"Auth"})
    @PutMapping("/v1/signup/{userId}/")
    public ResponseEntity<Map<String, Object>> signUpUser(@RequestBody UserRequest request, @PathVariable UUID userId) {

        service.createUser(
                new UserUserId(userId),
                new UserEmail(request.getEmail()),
                new UserPassword(request.getPassword())
        );

        return ResponseEntity.ok(Map.of("message", "User created successfully"));
    }

}


@Builder
@Data
class UserRequest {
    private String email;
    private String password;
}
