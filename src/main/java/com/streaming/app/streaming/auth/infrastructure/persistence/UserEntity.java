package com.streaming.app.streaming.auth.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
public class UserEntity {

    @Id
    private UUID userId;
    private String email;
    private String password;
}
