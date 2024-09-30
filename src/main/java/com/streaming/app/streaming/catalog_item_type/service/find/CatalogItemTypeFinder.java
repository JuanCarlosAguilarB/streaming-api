package com.streaming.app.streaming.catalog_item_type.service.find;

import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeRepository;
import com.streaming.app.streaming.catalog_item_type.domain.CatalogItemTypeResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogItemTypeFinder {

    private final CatalogItemTypeRepository repository;

    public List<CatalogItemTypeResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(CatalogItemTypeResponse::from)
                .collect(Collectors.toList());
    }

}
