package com.streaming.app.streaming.catalog_item_rating.infrastructure.controller;

import com.streaming.app.streaming.auth.domain.UserUserId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingId;
import com.streaming.app.streaming.catalog_item_rating.domain.UserRatingRating;
import com.streaming.app.streaming.catalog_item_rating.service.rate.CatalogItemRater;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class PutUserRating {

    private final CatalogItemRater service;

    @Operation(summary = "Rate a catalog item", description = "Rates a catalog item", tags = {"Catalog Item Rating"})
    @PutMapping("/v1/catalog-items/{catalogItemId}/ratings/")
    public ResponseEntity<?> rateCatalogItem(
            @PathVariable UUID catalogItemId,
            @RequestBody RatingRequest rating,
            UserUserId userId
    ) {
        service.rateCatalogItem(
                new UserRatingId(UUID.randomUUID()),
                new CatalogItemId(catalogItemId),
                userId,
                new UserRatingRating(rating.getRating())
        );

        return ResponseEntity.ok(Map.of("message", "rating created successfully"));

    }
}

@Getter
@Setter
class RatingRequest {
    private int rating;
}