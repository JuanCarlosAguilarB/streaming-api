package com.streaming.app.streaming.catalog_item.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogItemAverageScore {
    private Double value;

    public Double value() {
        return value;
    }
}
