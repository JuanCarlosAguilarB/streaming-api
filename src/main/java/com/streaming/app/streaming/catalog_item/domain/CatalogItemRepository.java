package com.streaming.app.streaming.catalog_item.domain;

public interface CatalogItemRepository {

    public void save(CatalogItem catalogItem);

    public CatalogItem findById(CatalogItemId id);

}
