package com.streaming.app.streaming.catalog_item_rating.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRatingJpaRepository extends JpaRepository<UserRatingEntity, UUID> {
    Boolean existsByUserIdAndCatalogItemId(UUID userId, UUID catalogItemId);
}
