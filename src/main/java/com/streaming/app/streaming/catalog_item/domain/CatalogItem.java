package com.streaming.app.streaming.catalog_item.domain;


import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CatalogItem {

    private CatalogItemId id;
    private CatalogItemTitle title;
    private CatalogItemGenreId genreId;
    private CatalogItemViews views;
    private CatalogItemAverageScore averageScore;
    private CatalogItemDescription description;
    private CatalogItemImage image;

    private CatalogItemTypeId catalogItemTypeId;


    public CatalogItemId id() {
        return id;
    }

    public CatalogItemTitle title() {
        return title;
    }

    public CatalogItemGenreId genreId() {
        return genreId;
    }

    public CatalogItemViews views() {
        return views;
    }

    public CatalogItemAverageScore averageScore() {
        return averageScore;
    }

    public CatalogItemDescription description() {
        return description;
    }

    public CatalogItemImage image() {
        return image;
    }

    public CatalogItemTypeId catalogItemTypeId() {
        return catalogItemTypeId;
    }

}
