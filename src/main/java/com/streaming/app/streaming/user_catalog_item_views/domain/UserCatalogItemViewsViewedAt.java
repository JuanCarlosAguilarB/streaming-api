package com.streaming.app.streaming.user_catalog_item_views.domain;

import java.time.LocalDateTime;

public class UserCatalogItemViewsViewedAt {

    private LocalDateTime value;

    public UserCatalogItemViewsViewedAt(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

}
