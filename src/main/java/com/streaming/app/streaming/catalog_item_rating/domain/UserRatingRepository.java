package com.streaming.app.streaming.catalog_item_rating.domain;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;

public interface UserRatingRepository {
    public Boolean existsByUserIdAndCatalogItemId(UserUserId userId, CatalogItemId catalogItemId);

    void save(UserRating userRating);
}
