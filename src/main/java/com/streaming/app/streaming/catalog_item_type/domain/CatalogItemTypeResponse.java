package com.streaming.app.streaming.catalog_item_type.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogItemTypeResponse {
    private int id;
    private String title;
    private String description;

    public static CatalogItemTypeResponse from(CatalogItemType catalogItemType) {
        return CatalogItemTypeResponse.builder()
                .id(catalogItemType.id().value())
                .title(catalogItemType.name().value())
                .description(catalogItemType.description().value())
                .build();
    }

}
