package com.streaming.app.streaming.catalog_item.service.find;

import com.streaming.app.streaming.catalog_item.domain.*;
import com.streaming.app.streaming.shared.domain.CatalogItemGenreId;
import com.streaming.app.streaming.shared.domain.CatalogItemTypeId;
import com.streaming.app.streaming.shared.domain.PageResult;
import com.streaming.app.streaming.shared.domain.PaginationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static com.streaming.app.streaming.shared.domain.GeneratorRandomValues.generateRandomValue;

@Service
@AllArgsConstructor
public class CatalogItemFinder {

    private final CatalogItemRepository repository;

    // TODO: I need to add filters to findRandomCatalogItem, (score, type, genre)
    public CatalogItem findRandomCatalogItem() {

        long total = (repository.count() > 0) ? repository.count() : 2;
        long random = generateRandomValue(1, total);

        return repository.findByCreatedOrder(new CatalogItemCreatedOrder(random)).orElseThrow(
                () -> new CatalogItemNotFoundException("No catalog item found."));

    }

    public PageResult<CatalogItem> getAllItems(CatalogItemTitle title, CatalogItemGenreId genreId, CatalogItemTypeId typeId, CatalogItemAverageScore score, PaginationRequest pageRequest) {

        // filter score by interval
        if (score != null) {
            double minScore = Math.floor(score.value());
            double maxScore = minScore + 0.99;
            return repository.findByAverageScoreBetween(
                    new CatalogItemAverageScore(minScore), new CatalogItemAverageScore(maxScore), pageRequest);
        }

        if (title != null && typeId != null && genreId != null) {
            return repository.findByTitleAndTypeIdAndGenreId(title, genreId, typeId, pageRequest);
        } else if (title != null) {
            return repository.findByTitle(title, pageRequest);
        } else if (typeId != null) {
            return repository.findByTypeId(typeId, pageRequest);
        } else if (genreId != null) {
            return repository.findByGenreId(genreId, pageRequest);
        }

        return repository.findAll(pageRequest);
    }


}
