package com.streaming.app.streaming.catalog_item_genre.service.find;

import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenre;
import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreRepository;
import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogItemGenreFinder {

    private final CatalogItemGenreRepository repository;

    public List<CatalogItemGenreResponse> findAll() {
        return repository.findAll().stream().map(CatalogItemGenreResponse::from).toList();
    }

}
