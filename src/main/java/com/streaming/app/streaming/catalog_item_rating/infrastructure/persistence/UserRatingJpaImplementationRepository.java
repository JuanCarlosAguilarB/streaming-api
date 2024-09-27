package com.streaming.app.streaming.catalog_item_rating.infrastructure.persistence;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRating;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.streaming.app.streaming.catalog_item_rating.infrastructure.persistence.UserRatingMapper.toEntity;

@Repository
@AllArgsConstructor
public class UserRatingJpaImplementationRepository implements UserRatingRepository {

    private final UserRatingJpaRepository repository;

    @Override
    public Boolean existsByUserIdAndCatalogItemId(UserUserId userId, CatalogItemId catalogItemId) {
        return repository.existsByUserIdAndCatalogItemId(userId.value(), catalogItemId.value());
    }

    @Override
    public void save(UserRating userRating) {
        repository.save(toEntity(userRating));
    }
}
