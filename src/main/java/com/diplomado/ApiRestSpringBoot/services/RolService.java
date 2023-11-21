package com.diplomado.ApiRestSpringBoot.services;

import com.diplomado.ApiRestSpringBoot.DTO.RolDTO;


import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> getRols();

    Optional<RolDTO> getRolById(Integer id);

    RolDTO save(RolDTO dto);

    void delete(Integer Id);
}
