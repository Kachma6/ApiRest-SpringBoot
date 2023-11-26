package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Data
public class UserRegisterDTO {

    @Valid

    private Long id;
    @NotNull(message = "Username is mandatory")
    @Size(min = 3, max = 20, message = "Nameuser must be between 3 and 20 characters")
    private String username;
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, max = 50, message = "Password must be between 8 and 50 characters")
    private String password;
    @NotNull(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    private LocalDateTime createdAt;
    private Integer iduserDetail;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;
//    private Set<UserRol> userRols;





}
