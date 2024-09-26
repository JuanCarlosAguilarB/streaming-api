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

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @ManyToOne(targetEntity = CatalogItemTypeEntity.class)
    @JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CatalogItemTypeEntity type;


    @Column(name = "genre_id", nullable = false)
    private Integer genreId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
    private CatalogItemGenreEntity genre;


}
