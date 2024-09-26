package com.streaming.app.streaming.catalog_item.domain;


public class CatalogItemCreatedOrder {

    private Long value;

    public CatalogItemCreatedOrder(Long value) {
        this.value = value;
    }

    public Long value() {
        return value;
    }

}
