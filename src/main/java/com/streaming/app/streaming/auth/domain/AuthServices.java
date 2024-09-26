package com.streaming.app.streaming.auth.domain;


public interface AuthServices {

    public TokenResponse createToken(UserEmail email);

    public User decode(TokenResponse token);

    public void ensureCredentialsAreValid(UserEmail userName, UserPassword password) throws CreadentialsNotValidException;

    public Boolean isValidToken(String token, String email);
}
