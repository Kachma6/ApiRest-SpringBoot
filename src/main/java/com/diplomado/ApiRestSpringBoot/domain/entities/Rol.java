package com.diplomado.ApiRestSpringBoot.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class Rol {

    @Id
    @SequenceGenerator(name ="rol_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence" )
    private Integer id;
    private String name;

  @JsonIgnore
    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
    Set<UserRol> userRols;
    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }
}
