package com.streaming.app.streaming.catalog_item_genre.domain;

import java.util.List;

public interface CatalogItemGenreRepository {
    public void save(CatalogItemGenre catalogItemGenre);
//    public CatalogItemGenre findById(CatalogItemGenreId id);
    List<CatalogItemGenre> findAll();
}
