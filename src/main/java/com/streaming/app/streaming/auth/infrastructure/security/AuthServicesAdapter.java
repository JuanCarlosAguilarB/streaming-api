package com.streaming.app.streaming.auth.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.streaming.app.streaming.auth.application.find.UserFinder;
import com.streaming.app.streaming.auth.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class AuthServicesAdapter implements AuthServices {


    //    @Value("${jwt.secret}")
    private final String secret = "secret";
    private final LocalDate now = LocalDate.now();
    private final Algorithm algorithm = Algorithm.HMAC256(this.secret);
    private final UserFinder userFinder;
    private final SecurityService securityService;

    @Override
    public TokenResponse createToken(UserEmail email) {
//        @Value("${jwt.refreshTokenExpirationInDays:11}")
        int refreshTokenExpirationInDays = 11;
        //    @Value("${jwt.accessTokenExpirationInDays:10}")
        int accessTokenExpirationInDays = 1000;

        String accessToken = generateToken(accessTokenExpirationInDays, email);
        String refreshToken = generateToken(refreshTokenExpirationInDays, email);

        return TokenResponse.builder()
                .token(accessToken)
                .refreshToken(refreshToken)
                .build();

    }

    @Override
    public void ensureCredentialsAreValid(UserEmail email, UserPassword password) {
        User user = userFinder.findByEmail(email);

        if (!securityService.matches(password.value(), user.password().value())) {
            throw new CreadentialsNotValidException("Invalid credentials");
        }
    }


    @Override
    public Boolean isValidToken(String token, String email) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);

            LocalDate now = LocalDate.now();

            return !decodedJWT.getExpiresAt().before(java.sql.Date.valueOf(now)) &&
                    decodedJWT.getSubject().equals(email);

        } catch (JWTDecodeException exception) {
            return false;
        }
    }


    private String generateToken(int expirationInDays, String subject) {

        LocalDate expiryDate = now.plusDays(expirationInDays);
        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(java.sql.Timestamp.valueOf(now.atStartOfDay()))
                .withExpiresAt(java.sql.Timestamp.valueOf(expiryDate.atStartOfDay()))
                .sign(algorithm);
    }

    @Override
    public User decode(TokenResponse token) throws UserNotFoundException {
        DecodedJWT decodedJWT = JWT.decode(token.getToken());
        return userFinder.findByEmail(new UserEmail(decodedJWT.getSubject()));
    }
}
