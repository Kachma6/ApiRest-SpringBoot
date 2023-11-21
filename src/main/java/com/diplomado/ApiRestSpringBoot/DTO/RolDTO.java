package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@ToString
@Getter
@Setter
public class RolDTO implements Serializable {
    private static final long serialVersionUID = 8799656478674712000L;
    private Integer id;
    private String name;
    private Set<UserRol> userRols;
    public RolDTO() {
    }
}
