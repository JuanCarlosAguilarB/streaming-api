package com.streaming.app.streaming.catalog_item_type.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemType;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CatalogItemTypeJpaImplementationRepository implements CatalogItemTypeRepository {

    private final CatalogItemTypeJpaRepository JpaRepository;


    @Override
    public List<CatalogItemType> findAll() {
        return JpaRepository.findAll()
                .stream()
                .map(CatalogItemTypeMapper::toDomain).toList();
    }

    @Override
    public void save(CatalogItemType catalogItem) {
        CatalogItemTypeEntity entity = CatalogItemTypeMapper.toEntity(catalogItem);
        JpaRepository.save(entity);

    }

}
