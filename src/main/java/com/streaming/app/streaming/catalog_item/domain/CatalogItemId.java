package com.streaming.app.streaming.catalog_item.domain;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class CatalogItemId {

    private UUID value;

    public UUID value() {
        return value;
    }

}
