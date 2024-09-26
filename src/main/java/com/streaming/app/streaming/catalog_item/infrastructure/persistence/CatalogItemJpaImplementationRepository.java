package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.CatalogItem;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemId;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemRepository;

import java.util.List;

public class CatalogItemJpaImplementationRepository implements CatalogItemRepository {
    @Override
    public void save(CatalogItem catalogItem) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public CatalogItem findById(CatalogItemId id) {
        return null;
    }

    @Override
    public List<CatalogItem> findByTitle(String title) {
        return List.of();
    }

    @Override
    public List<CatalogItem> findByGenre(String genre) {
        return List.of();
    }

    @Override
    public List<CatalogItem> findByOrderByViewsDesc() {
        return List.of();
    }
}
