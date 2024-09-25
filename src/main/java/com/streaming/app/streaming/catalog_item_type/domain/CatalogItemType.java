package com.streaming.app.streaming.catalog_item_type.domain;

import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogItemType {

    private CatalogItemTypeId id;
    private CatalogItemTypeName name;
    private CatalogItemTypeDescription description;

    public CatalogItemTypeId id() {
        return id;
    }

    public CatalogItemTypeName name() {
        return name;
    }

    public CatalogItemTypeDescription description() {
        return description;
    }
}
