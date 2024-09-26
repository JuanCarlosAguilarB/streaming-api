package com.streaming.app.streaming.auth.infrastructure.security;

import com.streaming.app.streaming.auth.domain.SecurityService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityServiceAdapter implements SecurityService {

    private final PasswordEncoder encoder;


    @Override
    public String encode(String textToEncode) {
        return encoder.encode(textToEncode);
    }

    @Override
    public Boolean matches(String textToEncode, String encodedText) {
        return encoder.matches(textToEncode, encodedText);
    }
}
