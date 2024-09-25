package com.streaming.app.streaming.catalog_item_genre.domain;

import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;

public interface CatalogItemGenreRepository {
    public void save(CatalogItemGenre catalogItemGenre);
    public CatalogItemGenre findById(CatalogItemGenreId id);
}
