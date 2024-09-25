package com.streaming.app.streaming.catalog_item.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CatalogItemDescription {
    private String value;

    public String value() {
        return value;
    }
}
