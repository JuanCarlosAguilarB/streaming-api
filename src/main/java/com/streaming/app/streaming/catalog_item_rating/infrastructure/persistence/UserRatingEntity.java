package com.streaming.app.streaming.catalog_item_rating.infrastructure.persistence;

import com.streaming.app.streaming.auth.infrastructure.persistence.UserEntity;
import com.streaming.app.streaming.catalog_item.infrastructure.persistence.CatalogItemEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class UserRatingEntity {

    @Id
    private UUID id;

    @Column(name = "catalog_item_id", nullable = false)
    private UUID catalogItemId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private Integer rating;

    @Column(name = "rated_at", nullable = false)
    private LocalDateTime ratedAt;

    @ManyToOne
    @JoinColumn(name = "catalog_item_id", nullable = false, insertable = false, updatable = false)
    private CatalogItemEntity catalogItem;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity user;

}