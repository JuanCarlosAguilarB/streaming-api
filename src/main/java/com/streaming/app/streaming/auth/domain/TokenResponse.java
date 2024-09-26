package com.streaming.app.streaming.auth.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse{

    private String token;
    private String refreshToken;

}
