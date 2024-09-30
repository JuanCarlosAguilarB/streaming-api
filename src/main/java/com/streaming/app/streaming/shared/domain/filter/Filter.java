package com.streaming.app.streaming.shared.domain.filter;

public interface Filter<T> {

    public T value();
    public String name();
}
