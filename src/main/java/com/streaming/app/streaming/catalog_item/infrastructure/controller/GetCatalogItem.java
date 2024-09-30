package com.streaming.app.streaming.catalog_item.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemResponse;
import com.streaming.app.streaming.catalog_item.service.find.CatalogItemFinder;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
public class GetCatalogItem {

    private final CatalogItemFinder service;


    @Operation(summary = "Get random catalog item", description = "Get random catalog item", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-items/random/")
    public ResponseEntity<?> getRandomCatalogItem() {
        return ResponseEntity.ok(service.findRandomCatalogItem());
    }

    @Operation(summary = "Get catalog items", description = "Get catalog items", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-items/")
    public ResponseEntity<?> getCatalogItems(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer genreId,
            @RequestParam(required = false) Integer typeId,
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "title") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDirection
    ) {
        HashMap<String, Object> filters = new HashMap<>();
        if (title != null) {
            filters.put("title", title);
        }
        if (genreId != null) {
            filters.put("genreId", genreId);
        }
        if (typeId != null) {
            filters.put("typeId", typeId);
        }
        if (score != null) {
            filters.put("averageScore", score);
        }

        PaginationRequest pagination = new PaginationRequest(
                page, size, sortBy, sortDirection, filters == null ? new HashMap<>() : filters
        );

        PageResult<CatalogItemResponse> items = service.getAllItems(
                pagination
        );

        return ResponseEntity.ok(items);
    }
}