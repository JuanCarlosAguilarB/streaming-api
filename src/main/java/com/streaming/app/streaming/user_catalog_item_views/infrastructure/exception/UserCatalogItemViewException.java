package com.streaming.app.streaming.user_catalog_item_views.infrastructure.exception;

import com.streaming.app.streaming.shared.domain.ApiExceptionResponse;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewDuplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserCatalogItemViewException {

    @ExceptionHandler(UserCatalogItemViewDuplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ApiExceptionResponse UserCatalogItemViewDuplicationHandler(UserCatalogItemViewDuplicationException ex) {
        return new ApiExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage()
        );
    }

}
