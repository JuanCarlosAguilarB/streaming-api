package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

        Sort sort = getSort(paginationRequest.getSortBy());
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));

        Page<CatalogItemEntity> page = repository.findByTitleContainingIgnoreCase(title.value(), pageable);
        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

    @Override
    public PageResult<CatalogItemResponse> findByGenreId(CatalogItemGenreId genreId, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        Page<CatalogItemEntity> page = repository.findByGenreId(genreId.value(), pageable);

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

    @Override
    public PageResult<CatalogItemResponse> findByTypeId(CatalogItemTypeId typeId, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        Page<CatalogItemEntity> page = repository.findByTypeId(typeId.value(), pageable);

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

    @Override
    public PageResult<CatalogItemResponse> findByAverageScoreBetween(CatalogItemAverageScore minScore, CatalogItemAverageScore maxScore, PaginationRequest paginationRequest) {
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        Page<CatalogItemEntity> page = repository.findByAverageScoreBetween(minScore.value(), maxScore.value(), pageable);

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }


    @Override
    public PageResult<CatalogItemResponse> findByTitleAndTypeIdAndGenreId(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, PaginationRequest paginationRequest) {

        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        Page<CatalogItemEntity> page = repository.findByTitleAndTypeIdAndGenreId(title.value(), typeId.value(), genreId.value(), pageable);

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
        );

        return response;
    }

    @Override
    public PageResult<CatalogItemResponse> findAll(PaginationRequest paginationRequest) {

        Sort sort = getSort(paginationRequest.getSortBy());
        Pageable pageable = PageRequest.of(paginationRequest.getPage(), paginationRequest.getSize(), getSort(paginationRequest.getSortBy()));
        Page<CatalogItemEntity> page = repository.findAll(pageable);

        PageResult<CatalogItemResponse> response = new PageResult<CatalogItemResponse>(
                page.stream().map(CatalogItemMapper::toResponse).toList(),
                paginationRequest.getPage(),
                paginationRequest.getSize(),
                page.getTotalElements()
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
