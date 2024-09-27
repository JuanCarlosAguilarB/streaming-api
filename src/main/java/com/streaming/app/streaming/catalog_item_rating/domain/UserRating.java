package com.streaming.app.streaming.catalog_item_rating.domain;


import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserRating {

    private UserRatingId id;
    private CatalogItemId catalogItemId;
    private UserUserId userId;
    private UserRatingRating rating;
    private UserRatingRatedAt ratedAt;

//    private CatalogItem catalogItem;
//    private User user;

    public UserRatingId id() {
        return id;
    }

    public CatalogItemId catalogItemId() {
        return catalogItemId;
    }

    public UserUserId userId() {
        return userId;
    }

    public UserRatingRating rating() {
        return rating;
    }

    public UserRatingRatedAt ratedAt() {
        return ratedAt;
    }

}
