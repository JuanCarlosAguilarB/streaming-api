package com.streaming.app.streaming.catalog_item.domain;

import java.util.List;

public interface CatalogItemRepository {

    public void save(CatalogItem catalogItem);

    public int count();

    public CatalogItem findById(CatalogItemId id);

    public List<CatalogItem> findByTitle(String title);
    public List<CatalogItem> findByGenre(String genre);
    public List<CatalogItem> findByOrderByViewsDesc();
}
