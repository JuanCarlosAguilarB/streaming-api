package com.streaming.app.streaming.user_catalog_item_views.infrastructure.controller;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewsId;
import com.streaming.app.streaming.user_catalog_item_views.service.viewed.UserCatalogItemViewCreator;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class PutUserCatalogItemViews {

    private final UserCatalogItemViewCreator service;

    @Operation(summary = "Create a user catalog item view", description = "Creates a user catalog item view", tags = {"User Catalog Item Views"})
    @PutMapping("/user-catalog-items/{catalogItemId}/views/")
    public void putUserCatalogItemViews(UserUserId userId, @PathVariable UUID catalogItemId) {
        service.create(
                new UserCatalogItemViewsId(UUID.randomUUID()),
                new CatalogItemId(catalogItemId),
                userId
        );
    }
}
