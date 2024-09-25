package com.streaming.app.streaming.catalog_item_type.service.find;

import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemType;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogItemTypeFinder {

    private final CatalogItemTypeRepository repository;

    public List<CatalogItemType> findAll() {
        return repository.findAll();
    }

}
