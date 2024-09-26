package com.streaming.app.streaming.auth.infrastructure.exception;


import com.streaming.app.streaming.auth.domain.CreadentialsNotValidException;
import com.streaming.app.streaming.auth.domain.UserNotFoundException;
import com.streaming.app.streaming.shared.domain.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;


@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(CreadentialsNotValidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiExceptionResponse handleBadCredentialsException(CreadentialsNotValidException ex) {
        return new ApiExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                ex.getMessage()
        );
    }


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiExceptionResponse handleUsernameNotFoundException(UserNotFoundException ex) {
        return new ApiExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage()
        );

    }

}
