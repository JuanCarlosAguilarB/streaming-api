package com.streaming.app.streaming.catalog_item.domain.sort;

import com.streaming.app.streaming.shared.domain.sort.SortBy;
import com.streaming.app.streaming.shared.domain.sort.SortDirection;

public class CalalogItemSortBytitle implements SortBy {

    private final String SORT_BY_TITLE = "title";
    private String sortDirection;

    public CalalogItemSortBytitle(String sortDirection) {
        this.sortDirection = SortDirection.of(sortDirection);
    }

    @Override
    public String sort() {
        return SORT_BY_TITLE;
    }

    @Override
    public String direction() {
        return sortDirection;
    }
}
