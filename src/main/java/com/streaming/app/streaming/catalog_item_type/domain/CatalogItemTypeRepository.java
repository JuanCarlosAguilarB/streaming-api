package com.streaming.app.streaming.catalog_item_type.domain;

import java.util.List;

public interface CatalogItemTypeRepository {
    public List<CatalogItemType> findAll();
    public void save(CatalogItemType catalogItem);
}
