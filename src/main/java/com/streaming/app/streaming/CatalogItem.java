package com.streaming.app.streaming;

import jakarta.persistence.*;

import java.util.UUID;

@Entity

public abstract class CatalogItem {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String genre;
    private Integer views;
    private Double averageScore;
    private String description;
    private String imageUrl;


    @ManyToOne(targetEntity = CatalogItemType.class)
    private Integer catalogItemTypeId;


}
