package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemJpaRepository extends JpaRepository<CatalogItemEntity, Integer> {
}
