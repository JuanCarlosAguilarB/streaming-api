package com.streaming.app.streaming.catalog_item_type.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemType;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeDescription;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeName;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;

public class CatalogItemTypeMapper {

    public static CatalogItemType toDomain(CatalogItemTypeEntity entity) {
        return new CatalogItemType(
                new CatalogItemTypeId(entity.getId()),
                new CatalogItemTypeName(entity.getName()),
                new CatalogItemTypeDescription(entity.getDescription())
        );
    }

    public static CatalogItemTypeEntity toEntity(CatalogItemType domain) {
        return CatalogItemTypeEntity.builder()
                .id(domain.id().value())
                .name(domain.name().value())
                .description(domain.description().value())
                .build();
    }

}
