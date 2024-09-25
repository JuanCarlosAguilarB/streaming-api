package com.streaming.app.streaming.catalog_item_type.infrastructure.controller;

import com.streaming.app.streaming.catalog_item_type.service.find.CatalogItemTypeFinder;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetCatalogItemType {

    private final CatalogItemTypeFinder service;

    @Operation(summary = "Get all types", description = "Get all types", tags = {"Types"})
    @GetMapping("/v1/catalog-item/types/")
    public ResponseEntity<?> getCatalogItemGenre() {
        return ResponseEntity.ok(service.findAll());
    }

}
