package com.streaming.app.streaming.catalog_item.domain;

import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;

import java.util.List;
import java.util.Optional;

public interface CatalogItemRepository {

    public void save(CatalogItem catalogItem);

    public Long count();

    public Optional<CatalogItem> findById(CatalogItemId id);
    public Optional<CatalogItem> findByCreatedOrder(CatalogItemCreatedOrder order);

    public List<CatalogItem> findByTitle(CatalogItemTitle title);
    public List<CatalogItem> findByGenreId(CatalogItemGenreId genre);
    public List<CatalogItem> findByOrderByViewsDesc();
}
