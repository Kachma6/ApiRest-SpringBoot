package com.diplomado.ApiRestSpringBoot.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

@Table(name = "user")
public class User {
    @Id
    @SequenceGenerator(name ="user_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;
    private String username;
    private String password;
    private String email;
    @Column(name = "created_at", columnDefinition = "TIMESTIME ")
    private LocalDateTime createdAt;

    public User() {
    }

    public User(String username, String password, String email, LocalDateTime createdAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
    }
}
