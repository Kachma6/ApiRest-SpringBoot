package com.diplomado.ApiRestSpringBoot.services;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserShowDTO> getUsers();
    List<UserShowDTO> getUsersDetail();

    Optional<UserShowDTO> getUserById(Long id);

    UserShowDTO save(UserRegisterDTO dto);

    void delete(Long Id);
}
