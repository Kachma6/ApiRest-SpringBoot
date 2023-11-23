package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserRolDTO {
    @Valid
    private Integer id;
    @NotNull(message = "Put status (active/inactive) is mandatory")
    private Boolean active;
    private LocalDateTime createdAt;
    @NotNull(message = "User id is mandatory")
    @NotBlank(message = "User id is mandatory")
    private User user;

    @NotNull(message = "Rol id is mandatory")
    @NotBlank(message = "User id is mandatory")
    private Rol rol;

}
