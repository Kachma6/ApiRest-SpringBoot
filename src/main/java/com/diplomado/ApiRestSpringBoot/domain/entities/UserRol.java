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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public UserRol() {
    }

    public UserRol(Boolean active, LocalDateTime createdAt, User user, Rol rol) {
        this.active = active;
        this.createdAt = createdAt;
        this.user = user;
        this.rol = rol;
    }
}
