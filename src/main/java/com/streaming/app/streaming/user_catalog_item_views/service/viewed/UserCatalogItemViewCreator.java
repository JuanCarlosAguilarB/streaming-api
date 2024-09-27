package com.streaming.app.streaming.user_catalog_item_views.service.viewed;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.user_catalog_item_views.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCatalogItemViewCreator {

    private final UserCatalogItemViewsRepository repository;

    public void create(UserCatalogItemViewsId userCatalogItemViewsId, CatalogItemId catalogItemId, UserUserId userId) {

        ensureCatalogItemWasNotViewed(catalogItemId, userId);

        UserCatalogItemViews userCatalogItemView = new UserCatalogItemViews(
                userCatalogItemViewsId,
                userId,
                catalogItemId,
                new UserCatalogItemViewsViewedAt(java.time.LocalDateTime.now())
        );
        repository.save(userCatalogItemView);

    }

    private void ensureCatalogItemWasNotViewed(CatalogItemId catalogItemId, UserUserId userId) {
        if (repository.existsByUserIdAndCatalogItemId(userId, catalogItemId)) {
            throw new UserCatalogItemViewDuplicationException("User has already viewed this item");
        }
    }

}
