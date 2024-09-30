package com.streaming.app.streaming.catalog_item.domain;

import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import com.streaming.app.streaming.shared.domain.filter.Filter;

import java.util.List;
import java.util.Optional;

public interface CatalogItemRepository {

    public void save(CatalogItem catalogItem);

    public Long count();

    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order, Optional<List<Filter>> filters);
    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest);

}
