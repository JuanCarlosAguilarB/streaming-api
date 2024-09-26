package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CatalogItemJpaRepository extends JpaRepository<CatalogItemEntity, UUID> {
    List<CatalogItemEntity> findByTitle(String value);
    List<CatalogItemEntity> findByGenreId(int value);
    List<CatalogItemEntity> findAllByOrderByViewsDesc();
}
