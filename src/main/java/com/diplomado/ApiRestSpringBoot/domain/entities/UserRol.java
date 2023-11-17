package com.diplomado.ApiRestSpringBoot.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "user_rol")
public class UserRol {
    @Id
    @SequenceGenerator(name = "user_rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_rol_sequence")
    private Integer id;
    private Boolean active;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    public UserRol() {
    }

    public UserRol(Boolean active, LocalDateTime createdAt) {
        this.active = active;
        this.createdAt = createdAt;
    }
}
