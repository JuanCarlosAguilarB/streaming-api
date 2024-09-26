package com.streaming.app.streaming.shared.domain;

public class GeneratorRandomValues {
    public static long generateRandomValue(long start, long end) {
        if (start >= end) {
            throw new IllegalArgumentException("The value of 'start' must be less than 'end'..");
        }
        return (long) (Math.random() * (end - start)) + start;
    }

    public static int generateRandomValue(int limit) {
        return (int) (Math.random() * limit);
    }

}
