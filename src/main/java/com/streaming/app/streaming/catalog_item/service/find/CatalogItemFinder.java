package com.streaming.app.streaming.catalog_item.service.find;

import com.streaming.app.streaming.catalog_item.domain.CatalogItem;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemCreatedOrder;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemNotFoundException;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.streaming.app.streaming.shared.domain.GeneratorRandomValues.generateRandomValue;

@Service
@AllArgsConstructor
public class CatalogItemFinder {

    private final CatalogItemRepository repository;

    public CatalogItem findRandomCatalogItem() {

        long total = (repository.count() > 0) ? repository.count() : 2;
        long random = generateRandomValue(1, total);

        return repository.findByCreatedOrder(new CatalogItemCreatedOrder(random)).orElseThrow(
                () -> new CatalogItemNotFoundException("No catalog item found."));

    }

}
