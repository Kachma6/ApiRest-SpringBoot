package com.diplomado.ApiRestSpringBoot.services;


import com.diplomado.ApiRestSpringBoot.DTO.UserRolDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserRolService {
    List<UserRolDTO> getUserRol();

    Optional<UserRolDTO> getUserRolById(Integer id);

    UserRolDTO save(UserRolDTO dto);


    void delete(Integer Id);

   UserRolDTO unsuscribeRol(Integer rolId, Long userId);

}
