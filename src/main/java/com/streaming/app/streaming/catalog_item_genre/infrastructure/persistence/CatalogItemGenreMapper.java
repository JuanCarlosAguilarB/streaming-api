package com.streaming.app.streaming.catalog_item_genre.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenre;
import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreDescription;
import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreName;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;

public class CatalogItemGenreMapper {

    public static CatalogItemGenre toDomain(CatalogItemGenreEntity entity) {
        return new CatalogItemGenre(
                new CatalogItemGenreId(entity.getId()),
                new CatalogItemGenreName(entity.getName()),
                new CatalogItemGenreDescription(entity.getDescription())
        );
    }

    public static CatalogItemGenreEntity toEntity(CatalogItemGenre domain) {
        return CatalogItemGenreEntity.builder()
                .id(domain.id().value())
                .name(domain.name().value())
                .description(domain.description().value())
                .build();
    }

}
