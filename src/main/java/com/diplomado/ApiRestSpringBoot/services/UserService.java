package com.diplomado.ApiRestSpringBoot.services;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService {
    List<UserRegisterDTO> getUsers();
    List<UserRegisterDTO> getUsersDetail();

    Optional<UserRegisterDTO> getUserById(Long id);

    UserRegisterDTO saveUserAndDetail(UserRegisterDTO user);

    UserRegisterDTO save(UserRegisterDTO dto);
//    UserShowDTO saveWithRols(UserRegisterDTO dto);
    void delete(Long Id);

    UserShowDTO edit (Long id, Map<String,Object> fields);
}
