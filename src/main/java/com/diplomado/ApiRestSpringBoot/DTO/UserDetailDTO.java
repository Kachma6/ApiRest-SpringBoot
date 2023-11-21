package com.diplomado.ApiRestSpringBoot.DTO;

import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import lombok.Data;


import java.time.LocalDate;
@Data
public class UserDetailDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthDay;
//    private User user;

    public UserDetailDTO() {
    }
}
