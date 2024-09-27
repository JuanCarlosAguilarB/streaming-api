package com.streaming.app.streaming.user_catalog_item_views.domain;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;

public interface UserCatalogItemViewsRepository {

    public void save(UserCatalogItemViews userCatalogItemViews);
    public Boolean existsByUserIdAndCatalogItemId(UserUserId userId, CatalogItemId catalogItemId);
}
