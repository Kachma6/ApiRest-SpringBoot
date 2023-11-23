package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class UserRolsDTO {
    @Valid
    private Integer id;
    @NotNull(message = "Put status (active/inactive) is mandatory")
    private Boolean active;
    private LocalDateTime createdAt;
    @NotNull(message = "User id is mandatory")

    private User user;

    @NotNull(message = "Rol id is mandatory")

    private List<Rol> rols;

}
