package com.streaming.app.streaming.catalog_item_genre.domain;


import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogItemGenre {

    private CatalogItemGenreId id;
    private CatalogItemGenreName name;
    private CatalogItemGenreDescription description;

    public CatalogItemGenreId id() {
        return id;
    }

    public CatalogItemGenreName name() {
        return name;
    }

    public CatalogItemGenreDescription description() {
        return description;
    }

}
