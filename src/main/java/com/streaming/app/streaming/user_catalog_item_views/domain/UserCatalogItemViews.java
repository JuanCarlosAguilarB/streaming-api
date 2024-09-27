package com.streaming.app.streaming.user_catalog_item_views.domain;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserCatalogItemViews {

    private UserCatalogItemViewsId id;
    private UserUserId userId;
    private CatalogItemId catalogItemId;
    private UserCatalogItemViewsViewedAt viewedAt;

    public UserCatalogItemViewsId id() {
        return id;
    }

    public UserUserId userId() {
        return userId;
    }

    public CatalogItemId catalogItemId() {
        return catalogItemId;
    }

    public UserCatalogItemViewsViewedAt viewedAt() {
        return viewedAt;
    }
}
