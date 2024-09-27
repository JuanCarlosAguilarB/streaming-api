package com.streaming.app.streaming.catalog_item_genre.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogItemGenreResponse {
    private int id;
    private String title;
    private String description;

    public static CatalogItemGenreResponse from(CatalogItemGenre catalogItemGenre) {
        return CatalogItemGenreResponse.builder()
                .id(catalogItemGenre.id().value())
                .title(catalogItemGenre.name().value())
                .description(catalogItemGenre.description().value())
                .build();
    }

}
