package com.streaming.app.streaming.catalog_item.infrastructure.persistence;

import com.streaming.app.streaming.catalog_item_genre.infrastructure.persistence.CatalogItemGenreEntity;
import com.streaming.app.streaming.catalog_item_type.infrastructure.persistence.CatalogItemTypeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class CatalogItemEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private Integer views;
    private Double averageScore;
    private String description;
    private String imageUrl;

    private Long creationOrder;

    @ManyToOne(targetEntity = CatalogItemTypeEntity.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id", nullable = false)
    private Integer typeId;


    @ManyToOne(targetEntity = CatalogItemGenreEntity.class)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Integer genreId;

}
