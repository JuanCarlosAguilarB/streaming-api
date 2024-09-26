package com.streaming.app.streaming.auth.infrastructure.controllers;


import com.streaming.app.streaming.auth.domain.AuthServices;
import com.streaming.app.streaming.auth.domain.TokenResponse;
import com.streaming.app.streaming.auth.domain.UserEmail;
import com.streaming.app.streaming.auth.domain.UserPassword;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Auth", description = "Authentication operations")
@AllArgsConstructor
public class AuthPostController {

    private final AuthServices authServices;

    @Operation(summary = "Authenticate a user", description = "Authenticates a user and returns a JWT token", tags = {"Auth"})
    @PostMapping("/v1/login/")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        UserEmail email = new UserEmail(loginRequest.getEmail());
        UserPassword password = new UserPassword(loginRequest.getPassword());

        authServices.ensureCredentialsAreValid(email,password);

        TokenResponse response =  authServices.createToken(email);

        return ResponseEntity.ok(response);

    }


}

class LoginRequest {
    private final String email;
    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;    }

    public String getPassword() {
        return password;
    }
}