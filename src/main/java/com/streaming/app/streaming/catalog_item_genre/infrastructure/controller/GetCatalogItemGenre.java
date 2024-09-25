package com.streaming.app.streaming.catalog_item_genre.infrastructure.controller;

import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenre;
import com.streaming.app.streaming.catalog_item_genre.service.find.CatalogItemGenreFinder;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class GetCatalogItemGenre {

    private final CatalogItemGenreFinder service;

    @Operation(summary = "Get all genres", description = "Get all genres", tags = {"Genre"})
    @GetMapping("/catalog_item_genre/")
    public ResponseEntity<?> getCatalogItemGenre() {
        return ResponseEntity.ok(service.findAll());
    }

}
