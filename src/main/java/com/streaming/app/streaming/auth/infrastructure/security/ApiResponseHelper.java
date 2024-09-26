package com.streaming.app.streaming.auth.infrastructure.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.time.LocalDateTime;


public class ApiResponseHelper {


    public static void sendErrorResponse(HttpServletResponse response, HttpStatus status, String error, String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");

        String jsonResponse = String.format("{\"timestamp\": \"%s\", \"status\": \"%d\", \"error\": \"%s\", \"message\": \"%s\"}",
                LocalDateTime.now(), status.value(), error, message);

        response.getWriter().write(jsonResponse);
    }
}