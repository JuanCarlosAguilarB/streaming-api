package com.streaming.app.streaming.catalog_item_type.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemTypeJpaRepository extends JpaRepository<CatalogItemTypeEntity, Integer> {
}
