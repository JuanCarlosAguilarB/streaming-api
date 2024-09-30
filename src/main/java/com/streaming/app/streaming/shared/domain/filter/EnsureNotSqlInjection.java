package com.streaming.app.streaming.shared.domain.filter;

public class EnsureNotSqlInjection {

    public static void execute(String value) {
        if (value.contains(";") || value.contains("'") || value.contains("\"")) {
            throw new IllegalArgumentException("Name cannot contain illegal characters");
        }
    }

}
