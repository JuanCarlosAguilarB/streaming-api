package com.streaming.app.streaming.auth.infrastructure.beans;

import com.streaming.app.streaming.auth.application.find.UserFinder;
import com.streaming.app.streaming.auth.domain.User;
import com.streaming.app.streaming.auth.domain.UserEmail;
import com.streaming.app.streaming.auth.domain.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@Configuration
@AllArgsConstructor
public class UserDetailsServiceBean {

    private final PasswordEncoder passwordEncoder;
    private final UserFinder userFinder;

    @ExceptionHandler({UserNotFoundException.class})
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UserNotFoundException {

                User user = userFinder.findByEmail(new UserEmail(email));

                return new org.springframework.security.core.userdetails.User(
                        user.email().value(), user.password().value(),
                        true, true, true, true, Collections.emptyList());
            }
        };
    }





}
