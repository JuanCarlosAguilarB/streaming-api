package com.streaming.app.streaming.catalog_item.domain;

public class CatalogItemNotFoundException extends RuntimeException {

    public CatalogItemNotFoundException(String message) {
        super(message);
    }

}
