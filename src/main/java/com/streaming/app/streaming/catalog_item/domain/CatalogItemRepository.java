package com.streaming.app.streaming.catalog_item.domain;

import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;

import java.util.Optional;

public interface CatalogItemRepository {

    public void save(CatalogItem catalogItem);

    public Long count();

//    public Optional<CatalogItem> findById(CatalogItemId id);
    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order);

    public PageResult<CatalogItemResponse> findByTitle(CatalogItemTitle title, PaginationRequest paginationRequest);
    public PageResult<CatalogItemResponse> findByGenreId(CatalogItemGenreId genreId, PaginationRequest paginationRequest);
    public PageResult<CatalogItemResponse> findByTypeId(CatalogItemTypeId typeId, PaginationRequest paginationRequest);
    public PageResult<CatalogItemResponse> findByAverageScoreBetween(CatalogItemAverageScore minScore, CatalogItemAverageScore maxScore, PaginationRequest paginationRequest);
    public PageResult<CatalogItemResponse> findByTitleAndTypeIdAndGenreId(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, PaginationRequest paginationRequest);

    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest);

}
