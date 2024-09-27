package com.streaming.app.streaming.user_catalog_item_views.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserCatalogItemViewsJpaRepository extends JpaRepository<UserCatalogItemViewsEntity, UUID> {
    public Boolean existsByUserIdAndCatalogItemId(UUID userId, UUID catalogItemId);
}
