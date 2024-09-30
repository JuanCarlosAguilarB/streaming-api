package com.streaming.app.streaming.user_catalog_item_views.infrastructure.controller;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.auth.infrastructure.controllers.RetriveUserIdOfAuthenticatedUser;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.user_catalog_item_views.domain.UserCatalogItemViewsId;
import com.streaming.app.streaming.user_catalog_item_views.service.viewed.UserCatalogItemViewCreator;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PutUserCatalogItemViews {

    private final UserCatalogItemViewCreator service;
    private final RetriveUserIdOfAuthenticatedUser retirveUserId;

    @Operation(summary = "Create a user catalog item view", description = "Creates a user catalog item view", tags = {"User Catalog Item Views"})
    @PutMapping("/v1/user-catalog-items/{catalogItemId}/views/")
    public ResponseEntity<?> putUserCatalogItemViews(@PathVariable UUID catalogItemId) {

        UserUserId userId = retirveUserId.get();
        System.out.println(userId.value());

        service.create(
                new UserCatalogItemViewsId(UUID.randomUUID()),
                new CatalogItemId(catalogItemId),
                userId
        );
        return ResponseEntity.ok(Map.of("message", "viewing created successfully"));
    }

}
