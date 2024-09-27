package com.streaming.app.streaming.catalog_item_rating.infrastructure.exception;

import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingDuplicationException;
import com.streaming.app.streaming.shared.domain.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserRatingExceptionHandler {


    @ExceptionHandler(UserRatingDuplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiExceptionResponse UserRatingExceptionHandler(UserRatingDuplicationException ex) {
        return new ApiExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage()
        );
    }

}
