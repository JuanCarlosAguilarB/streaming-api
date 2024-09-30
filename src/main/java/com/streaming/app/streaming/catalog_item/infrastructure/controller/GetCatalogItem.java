package com.streaming.app.streaming.catalog_item.infrastructure.controller;

import com.streaming.app.streaming.catalog_item.domain.CatalogItemResponse;
import com.streaming.app.streaming.catalog_item.domain.filters.CatalogItemGenreIdFilter;
import com.streaming.app.streaming.catalog_item.domain.filters.CatalogItemTitleFilter;
import com.streaming.app.streaming.catalog_item.domain.filters.ScoreFilterBetweenIntervals;
import com.streaming.app.streaming.catalog_item.domain.sort.CalalogItemSortBytitle;
import com.streaming.app.streaming.catalog_item.service.find.CatalogItemFinder;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import com.streaming.app.streaming.shared.domain.filter.Filter;
import com.streaming.app.streaming.shared.domain.sort.SortBy;
import com.streaming.app.streaming.shared.domain.sort.SortDirection;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class GetCatalogItem {

    private final CatalogItemFinder service;


    @Operation(summary = "Get random catalog item", description = "Get random catalog item", tags = {"Catalog Item"})
    @GetMapping("/v1/catalog-items/random/")
    public ResponseEntity<?> getRandomCatalogItem(
            @RequestParam(required = false) Integer genreId,
            @RequestParam(required = false) Integer typeId,
            @RequestParam(required = false) Integer score) {

        List<Filter> filters = getFilters(null, genreId, typeId, score);
        return ResponseEntity.ok(
                service.findRandomCatalogItem(filters)
        );
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
        List<Filter> filters = getFilters(title, genreId, typeId, score);
        SortBy sort = getSort(sortBy, sortDirection);

        PaginationRequest pagination = new PaginationRequest(
                page, size, sortBy, sort, filters
        );

        PageResult<CatalogItemResponse> items = service.getAllItems(
                pagination
        );

        return ResponseEntity.ok(items);
    }

    private SortBy getSort(String sortBy, String sortDirection) {

        System.out.println("sortBy: " + sortBy);
        System.out.println("sortDirection: " + sortDirection);
        System.out.println(SortDirection.of(sortDirection));

        if (sortBy.equalsIgnoreCase("title")) {
            return new CalalogItemSortBytitle(SortDirection.of(sortDirection));
        }

        return new CalalogItemSortBytitle(SortDirection.of(sortDirection));
    }

    private List<Filter> getFilters(String title, Integer genreId, Integer typeId, Integer score) {
        List<Filter> filters = new ArrayList<>();

        if (title != null) {
            filters.add(new CatalogItemTitleFilter(title));
        }
        if (genreId != null) {
            filters.add( new CatalogItemGenreIdFilter(genreId));
        }
        if (typeId != null) {
            filters.add( new CatalogItemGenreIdFilter(typeId));
        }
        if (score != null) {
            filters.add( new ScoreFilterBetweenIntervals(score));
        }

        return filters;
    }

}