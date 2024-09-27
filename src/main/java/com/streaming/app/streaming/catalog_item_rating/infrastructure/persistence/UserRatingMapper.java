package com.streaming.app.streaming.catalog_item_rating.infrastructure.persistence;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRating;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingId;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingRatedAt;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingRating;

public class UserRatingMapper {

    public static UserRating toDomain(UserRatingEntity entity) {
        return new UserRating(
                new UserRatingId(entity.getId()),
                new CatalogItemId(entity.getCatalogItemId()),
                new UserUserId(entity.getUserId()),
                new UserRatingRating(entity.getRating()),
                new UserRatingRatedAt(entity.getRatedAt())
        );
    }

    public static UserRatingEntity toEntity(UserRating userRating) {
        return UserRatingEntity.builder()
                .id(userRating.id().value())
                .catalogItemId(userRating.catalogItemId().value())
                .userId(userRating.userId().value())
                .rating(userRating.rating().value())
                .ratedAt(userRating.ratedAt().value())
                .build();
    }
}
