package com.streaming.app.streaming.catalog_item_genre.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemGenreJpaRepository extends JpaRepository<CatalogItemGenreEntity, Integer> {
}
