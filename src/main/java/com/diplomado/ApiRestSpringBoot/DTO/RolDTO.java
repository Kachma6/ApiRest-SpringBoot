package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Valid
    private Integer id;
    @NotNull(message = "name is mandatory")
    @Size(min = 4, max = 20, message = "Name must be between 4 and 20 characters")
    private String name;
    private Set<UserRol> userRols;
    private Set<String> listRols;
    public RolDTO() {
    }
}
