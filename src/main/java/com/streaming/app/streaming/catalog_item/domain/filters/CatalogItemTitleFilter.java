package com.streaming.app.streaming.catalog_item.domain.filters;

import com.streaming.app.streaming.shared.domain.filter.Filter;

import static com.streaming.app.streaming.shared.domain.filter.EnsureNotSqlInjection.execute;
public class CatalogItemTitleFilter implements Filter<String> {

    private String name;

    public CatalogItemTitleFilter(String name) {
        ensureIsAValidName(name);
        this.name = name;
    }

    private void ensureIsAValidName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        execute(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String value() {
        return name;
    }

    @Override
    public String name() {
        return "title";
    }
}
