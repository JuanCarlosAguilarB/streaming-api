package com.streaming.app.streaming.catalog_item_type.domain;

import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogItemType {

    private CatalogItemTypeId id;
    private CatalogItemTypeName name;
    private CatalogItemTypeDescription description;

}
