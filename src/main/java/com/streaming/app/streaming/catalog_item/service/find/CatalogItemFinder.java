package com.streaming.app.streaming.catalog_item.service.find;

import com.streaming.app.streaming.catalog_item.domain.CatalogItemCreatedOrder;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemNotFoundException;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemRepository;
import com.streaming.app.streaming.catalog_item.domain.CatalogItemResponse;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import com.streaming.app.streaming.shared.domain.filter.Filter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.streaming.app.streaming.shared.domain.GeneratorRandomValues.generateRandomValue;

@Service
@AllArgsConstructor
public class CatalogItemFinder {

    private final CatalogItemRepository repository;

    // TODO: I need to add filters to findRandomCatalogItem, (score, type, genre)
    public CatalogItemResponse findRandomCatalogItem(List<Filter> filters) {
        Optional<List<Filter>> filtersOptional = Optional.empty();
        if ( filters != null && !filters.isEmpty()) {
            filtersOptional = Optional.of(filters);
        }

        long total = (repository.count() > 0) ? repository.count() : 2;
        long random = generateRandomValue(1, total);

        return repository.findByCreatedOrder(new CatalogItemCreatedOrder(random), filtersOptional).orElseThrow(
                () -> new CatalogItemNotFoundException("No catalog item found."));

    }

    public PageResult<CatalogItemResponse> getAllItems(
            PaginationRequest pageRequest) {
        return repository.findAll(pageRequest);
    }


}
