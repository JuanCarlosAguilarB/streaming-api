package com.streaming.app.streaming.catalog_item_rating.domain;

public class UserRatingDuplicationException extends RuntimeException {
    public UserRatingDuplicationException(String message) {
        super(message);
    }
}
