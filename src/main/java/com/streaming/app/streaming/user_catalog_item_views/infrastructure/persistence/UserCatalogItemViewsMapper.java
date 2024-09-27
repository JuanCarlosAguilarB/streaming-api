package com.streaming.app.streaming.user_catalog_item_views.infrastructure.persistence;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViews;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewsId;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewsViewedAt;

public class UserCatalogItemViewsMapper {

    public static UserCatalogItemViews toDomain(UserCatalogItemViewsEntity userCatalogItemViewsEntity) {

        return new UserCatalogItemViews(
                new UserCatalogItemViewsId(userCatalogItemViewsEntity.getId()),
                new UserUserId(userCatalogItemViewsEntity.getUserId()),
                new CatalogItemId(userCatalogItemViewsEntity.getCatalogItemId()),
                new UserCatalogItemViewsViewedAt(userCatalogItemViewsEntity.getViewedAt())
        );
    }

    public static UserCatalogItemViewsEntity toEntity(UserCatalogItemViews userCatalogItemViews) {

        return UserCatalogItemViewsEntity.builder()
                .id(userCatalogItemViews.id().value())
                .userId(userCatalogItemViews.userId().value())
                .catalogItemId(userCatalogItemViews.catalogItemId().value())
                .viewedAt(userCatalogItemViews.viewedAt().value())
                .build();
    }

}
