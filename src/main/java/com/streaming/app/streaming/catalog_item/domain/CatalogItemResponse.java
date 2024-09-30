package com.streaming.app.streaming.catalog_item.domain;

import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreName;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeName;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CatalogItemResponse {

    private UUID id;
    private String title;
    private Integer views;
    private Double averageScore;
    private String description;
    private String imageUrl;
    private Long creationOrder;
    private String genre;
    private String type;

    public static CatalogItemResponse from(CatalogItem catalogItem, CatalogItemGenreName catalogItemGenreName, CatalogItemTypeName catalogItemTypeName) {
        return CatalogItemResponse.builder()
                .id(catalogItem.id().value())
                .title(catalogItem.title().value())
                .description(catalogItem.description().value())
                .genre(catalogItemGenreName.value())
                .views(catalogItem.views().value())
                .averageScore(catalogItem.averageScore().value())
                .creationOrder(catalogItem.order().value())
                .type(catalogItemTypeName.value())
                .build();
    }

}
