package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
public class UserRegisterDTO {
    private Long id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private UserDetail userDetail;
    private Set<UserRol> userRols;





}
