package com.streaming.app.streaming.catalog_item_rating.domain;

import java.util.UUID;

public class UserRatingId {
    private UUID value;

    public UserRatingId(UUID value) {
        this.value = value;
    }

    public UUID value() {
        return value;
    }
}
