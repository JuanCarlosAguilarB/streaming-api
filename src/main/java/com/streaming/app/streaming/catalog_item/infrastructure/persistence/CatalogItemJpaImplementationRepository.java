package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Optional<CatalogItemResponse> findByCreatedOrder(CatalogItemCreatedOrder order) {
        return repository.findByCreationOrder(order.value()).map(CatalogItemMapper::toResponse);
    }

    @Override
    public PageResult<CatalogItemResponse> findByTitle(CatalogItemTitle title, PaginationRequest paginationRequest) {
//        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
//        return PageResult.of(repository.findByTitleContainingIgnoreCase(title.value(), pageable).stream().map(CatalogItemMapper::toDomain).toList(), paginationRequest);
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findByGenreId(CatalogItemGenreId genreId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findByTypeId(CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findByAverageScoreBetween(CatalogItemAverageScore minScore, CatalogItemAverageScore maxScore, PaginationRequest paginationRequest) {
        return null;
    }


    @Override
    public PageResult<CatalogItemResponse> findByTitleAndTypeIdAndGenreId(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest) {
        Sort sort = getSort(paginationRequest.getSortBy());
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        repository.findAll(pageable).stream().map(CatalogItemMapper::toResponse).toList();

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                repository.findAll(pageable).stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                repository.count()
        );

        return response;
    }

    private Sort getSort(String sortBy) {
            if (sortBy.equals("title")) {
                return Sort.by(Sort.Direction.ASC, "title");
            }
            if (sortBy.equals("genreId")) {
                return Sort.by(Sort.Direction.ASC, "genreId");
            }
            if (sortBy.equals("typeId")) {
                return Sort.by(Sort.Direction.ASC, "typeId");
            }
            if (sortBy.equals("averageScore")) {
                return Sort.by(Sort.Direction.DESC, "averageScore");
            }
            if (sortBy.equals("created")) {
                return Sort.by(Sort.Direction.DESC, "created");
            }
        return Sort.by(Sort.Direction.ASC, "title");
    }

}
