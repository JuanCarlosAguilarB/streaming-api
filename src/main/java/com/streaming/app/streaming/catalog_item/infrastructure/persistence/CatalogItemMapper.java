package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;

public class CatalogItemMapper {

    public static CatalogItemEntity toEntity(CatalogItem catalogItem) {

        return CatalogItemEntity.builder()
                .id(catalogItem.id().value())
                .title(catalogItem.title().value())
                .description(catalogItem.description().value())
                .genreId(catalogItem.genreId().value())
                .views(catalogItem.views().value())
                .averageScore(catalogItem.averageScore().value())
                .creationOrder(catalogItem.order().value())
                .build();
    }

    public static CatalogItem toDomain(CatalogItemEntity catalogItemEntity) {
        return new CatalogItem(
                new CatalogItemId(catalogItemEntity.getId()),
                new CatalogItemTitle(catalogItemEntity.getTitle()),
                new CatalogItemGenreId(catalogItemEntity.getGenreId()),
                new CatalogItemViews(catalogItemEntity.getViews()),
                new CatalogItemAverageScore(catalogItemEntity.getAverageScore()),
                new CatalogItemDescription(catalogItemEntity.getDescription()),
                new CatalogItemImage(catalogItemEntity.getImageUrl()),
                new CatalogItemCreatedOrder(catalogItemEntity.getCreationOrder()),
                new CatalogItemTypeId(catalogItemEntity.getTypeId())
        );
    }
}
