package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.streaming.app.streaming.catalog_item.infrastructure.persistence.CatalogItemMapper.toEntity;

@Repository
@AllArgsConstructor
public class CatalogItemJpaImplementationRepository implements CatalogItemRepository {

    private final CatalogItemJpaRepository repository;

    @Override
    public void save(CatalogItem catalogItem) {
        CatalogItemEntity entity = toEntity(catalogItem);
        repository.save(entity);
    }

    @Override
    public Long count() {
        return repository.count();
    }


    @Override
    public Optional<CatalogItem> findByCreatedOrder(CatalogItemCreatedOrder order) {
        return repository.findByCreationOrder(order.value()).map(CatalogItemMapper::toDomain);
    }

    @Override
    public PageResult<CatalogItem> findByTitle(CatalogItemTitle title, PaginationRequest paginationRequest) {
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        return PageResult.of(repository.findByTitleContainingIgnoreCase(title.value(), pageable).stream().map(CatalogItemMapper::toDomain).toList(), paginationRequest);
        return null;
    }

    @Override
    public PageResult<CatalogItem> findByGenreId(CatalogItemGenreId genreId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItem> findByTypeId(CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItem> findByAverageScoreBetween(CatalogItemAverageScore minScore, CatalogItemAverageScore maxScore, PaginationRequest paginationRequest) {
        return null;
    }


    @Override
    public PageResult<CatalogItem> findByTitleAndTypeIdAndGenreId(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItem> findAll(PaginationRequest paginationRequest) {
        return null;
    }


}
