package com.streaming.app.streaming.catalog_item.infrastructure.controller;

import com.streaming.app.streaming.catalog_item.domain.CatalogItem;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemAverageScore;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemTitle;
import com.streaming.app.streaming.catalog_item.service.find.CatalogItemFinder;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetCatalogItem {

    private final CatalogItemFinder service;


    @Operation(summary = "Get random catalog item", description = "Get random catalog item", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-item/random/")
    public ResponseEntity<?> getRandomCatalogItem() {
        return ResponseEntity.ok(service.findRandomCatalogItem());
    }

    @Operation(summary = "Get catalog items", description = "Get catalog items", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-item/")
    public ResponseEntity<?> getCatalogItems(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer typeId,
            @RequestParam(required = false) Integer genreId,
            @RequestParam(required = false) Double score,
            @RequestParam(required = false) Pageable pageable) {

        String sort = pageable.getSort().toString();
        PaginationRequest pagination = new PaginationRequest(pageable.getPageNumber(), pageable.getPageSize(), sort);

        PageResult<CatalogItem> items = service.getAllItems(
                title != null ? new CatalogItemTitle(title) : null,
                genreId != null ? new CatalogItemGenreId(genreId) : null,
                title != null ? new CatalogItemTypeId(typeId) : null,
                score != null ? new CatalogItemAverageScore(score) : null,
                pagination
        );

        return ResponseEntity.ok(items);
    }
}
