package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class UserShowDTO {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private UserDetail userDetail;
//    private Set<UserRol> userRols;

}
