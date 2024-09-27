package com.streaming.app.streaming.user_catalog_item_views.infrastructure.persistence;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViews;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.streaming.app.streaming.user_catalog_item_views.infrastructure.persistence.UserCatalogItemViewsMapper.toEntity;

@Repository
@AllArgsConstructor
public class UserCatalogItemViewsJpaImplementationRepository implements UserCatalogItemViewsRepository {

    private final UserCatalogItemViewsJpaRepository repository;

    @Override
    public void save(UserCatalogItemViews userCatalogItemViews) {
        repository.save(toEntity(userCatalogItemViews));
    }

    @Override
    public Boolean existsByUserIdAndCatalogItemId(UserUserId userId, CatalogItemId catalogItemId) {
        return repository.existsByUserIdAndCatalogItemId(userId.value(), catalogItemId.value());
    }
}
