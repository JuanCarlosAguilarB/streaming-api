package com.streaming.app.streaming.catalog_item.infrastructure.config.exception;

import com.streaming.app.streaming.catalog_item.domain.CatalogItemNotFoundException;
import com.streaming.app.streaming.shared.domain.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class CatalogItemException {

    @ExceptionHandler(CatalogItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiExceptionResponse handleThrowable(CatalogItemNotFoundException ex) {
        return new ApiExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage()
        );
    }

}
