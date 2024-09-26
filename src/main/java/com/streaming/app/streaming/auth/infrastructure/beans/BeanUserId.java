package com.streaming.app.streaming.auth.infrastructure.beans;


import com.streaming.app.streaming.auth.domain.AuthServices;
import com.streaming.app.streaming.auth.domain.TokenResponse;
import com.streaming.app.streaming.auth.domain.User;
import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.auth.infrastructure.security.RetrieveTokenFromRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class BeanUserId {

    private final AuthServices authServices;
    private final RetrieveTokenFromRequest retrieveTokenservice;

    @Bean
    public UserUserId getUserId() {

        String token = retrieveTokenservice.execute();

        if (token == null) {
            return null;
        }

        User user = authServices.decode(
                TokenResponse.builder().token(token).build()
        );

        return user.id();
    }


}


