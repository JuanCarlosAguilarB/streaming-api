package com.streaming.app.streaming.catalog_item_rating.service.rate;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.catalog_item_rating.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CatalogItemRater {

    private final UserRatingRepository repository;

    public void rateCatalogItem(UserRatingId ratingId,CatalogItemId catalogItemId, UserUserId userId, UserRatingRating rating) {
        ensureCatalogItemWasNotRate(catalogItemId, userId);

        UserRating userRating = new UserRating(
                ratingId,
                catalogItemId,
                userId,
                rating,
                new UserRatingRatedAt(LocalDateTime.now())
        );

        repository.save(userRating);

    }


    private void ensureCatalogItemWasNotRate(CatalogItemId catalogItemId, UserUserId userId) {
        if (repository.existsByUserIdAndCatalogItemId(userId, catalogItemId)) {
            throw new UserRatingDuplicationException("User has already rated this item");
        }
    }
}
