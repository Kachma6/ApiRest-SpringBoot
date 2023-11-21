package com.diplomado.ApiRestSpringBoot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter

@Table(name = "user", schema = "public")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name ="user_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String username;
    private String password;
    private String email;
    @Column(name = "created_at", columnDefinition = "TIMESTIME ")
    private LocalDateTime createdAt;

  @JsonIgnore
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserDetail userDetail;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<UserRol> userRols;




    public User(String username, String password, String email, LocalDateTime createdAt, UserDetail userDetail) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.userDetail = userDetail;

    }

    public User() {
    }


}
