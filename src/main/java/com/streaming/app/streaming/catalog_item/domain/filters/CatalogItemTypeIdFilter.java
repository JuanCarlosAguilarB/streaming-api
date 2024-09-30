package com.streaming.app.streaming.catalog_item.domain.filters;

import com.streaming.app.streaming.shared.domain.filter.Filter;

public class CatalogItemTypeIdFilter implements Filter<Integer> {

    private Integer typeId;

    public CatalogItemTypeIdFilter(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    @Override
    public Integer value() {
        return typeId;
    }

    @Override
    public String name() {
        return "genreId";
    }
}
