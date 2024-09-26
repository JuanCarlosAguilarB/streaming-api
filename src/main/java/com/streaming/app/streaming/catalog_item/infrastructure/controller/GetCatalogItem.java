package com.streaming.app.streaming.catalog_item.infrastructure.controller;

import com.streaming.app.streaming.catalog_item.service.find.CatalogItemFinder;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetCatalogItem {

    private final CatalogItemFinder service;

    @Operation(summary = "Get random catalog item", description = "Get random catalog item", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-item/")
    public ResponseEntity<?> getRandomCatalogItem() {
        return ResponseEntity.ok(service.findRandomCatalogItem());
    }

}
