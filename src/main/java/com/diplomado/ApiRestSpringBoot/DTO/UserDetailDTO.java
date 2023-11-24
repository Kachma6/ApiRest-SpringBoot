package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.time.LocalDate;
@Data
public class UserDetailDTO {
    @Valid
    private Integer id;
    @NotNull(message = "Firstname is mandatory")
    @Size(min = 2, max = 20 , message = "Firstname must be between 8 and 20 characters")
    private String firstName;
    @NotNull(message = "Lastname is mandatory")
    @Size(min = 2, max = 20 ,message = "Lastname must be between 8 and 20 characters")
    private String lastName;
    @NotNull(message = "Age is mandatory")
    @Min(18)
    private Integer age;
    @Past(message = "The birthDay must be in past time")
    @NotNull
    private LocalDate birthDay;
   private User user;

    public UserDetailDTO() {
    }
}
