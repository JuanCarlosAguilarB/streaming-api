package com.streaming.app.streaming.catalog_item.domain.filters;

import com.streaming.app.streaming.shared.domain.filter.Filter;

public class CatalogItemGenreIdFilter implements Filter<Integer> {

    private Integer genreId;

    public CatalogItemGenreIdFilter(Integer genreId) {
        this.genreId = genreId;
    }


    @Override
    public Integer value() {
        return genreId;
    }

    @Override
    public String name() {
        return "genreId";
    }
}
