package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public Optional<CatalogItem> findById(CatalogItemId id) {
        return repository.findById(id.value()).map(CatalogItemMapper::toDomain);
    }

    @Override
    public Optional<CatalogItem> findByCreatedOrder(CatalogItemCrationOrder order) {
        return repository.findByCreationOrder(order.value()).map(CatalogItemMapper::toDomain);
    }

    @Override
    public List<CatalogItem> findByTitle(CatalogItemTitle title) {
        return repository.findByTitle(title.value()).stream().map(CatalogItemMapper::toDomain).toList();
    }

    @Override
    public List<CatalogItem> findByGenreId(CatalogItemGenreId genre) {
        return repository.findByGenreId(genre.value()).stream().map(CatalogItemMapper::toDomain).toList();
    }

    @Override
    public List<CatalogItem> findByOrderByViewsDesc() {
        return repository.findAllByOrderByViewsDesc().stream().map(CatalogItemMapper::toDomain).toList();
    }
}
