package com.streaming.app.streaming.catalog_item_genre.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenre;
import com.streaming.app.streaming.catalog_item_genre.domain.CatalogItemGenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CatalogItemGenreJpaImplementationRepository implements CatalogItemGenreRepository {

    private final CatalogItemGenreJpaRepository JpaRepository;

    @Override
    public void save(CatalogItemGenre catalogItemGenre) {
        CatalogItemGenreEntity entity = CatalogItemGenreMapper.toEntity(catalogItemGenre);
        JpaRepository.save(entity);
    }

    @Override
    public List<CatalogItemGenre> findAll() {
        return JpaRepository.findAll()
                .stream()
                .map(CatalogItemGenreMapper::toDomain).toList();
    }

}
