package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CatalogItemJpaRepository extends JpaRepository<CatalogItemEntity, UUID> {

    Optional<CatalogItemEntity> findByCreationOrder(Long order);

    Page<CatalogItemEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
    Page<CatalogItemEntity> findByTypeId(Integer typeId, Pageable pageable);
    Page<CatalogItemEntity> findByGenreId(Integer genreId, Pageable pageable);
    Page<CatalogItemEntity> findByAverageScore(Integer score, Pageable pageable);

    Page<CatalogItemEntity> findByTitleAndTypeIdAndGenreId(String title,Integer typeId, Integer genreId, Pageable pageable);
    Page<CatalogItemEntity> findByAverageScoreBetween(Double minScore, Double maxScore, Pageable pageable);

}
