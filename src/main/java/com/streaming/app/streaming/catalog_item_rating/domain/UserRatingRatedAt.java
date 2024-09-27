package com.streaming.app.streaming.catalog_item_rating.domain;

import java.time.LocalDateTime;

public class UserRatingRatedAt {
    private LocalDateTime value;

    public UserRatingRatedAt(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }
}
