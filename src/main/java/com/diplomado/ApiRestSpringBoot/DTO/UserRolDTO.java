package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserRolDTO {

    private Integer id;
    private Boolean active;
    private LocalDateTime createdAt;
    private User user;
    private Rol rol;

}
