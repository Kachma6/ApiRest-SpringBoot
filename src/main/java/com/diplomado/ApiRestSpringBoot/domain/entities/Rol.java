package com.diplomado.ApiRestSpringBoot.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Rol() {
    }

    public Rol(String name) {
        this.name = name;
    }
}
