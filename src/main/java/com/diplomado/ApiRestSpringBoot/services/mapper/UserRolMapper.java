package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserRolDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreatedAt(userRol.getCreatedAt());
        dto.setUser(userRol.getUser());
        dto.setRol(userRol.getRol());
        return dto;
    }


    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol dto = new UserRol();
        dto.setId(userRolDTO.getId());
        dto.setActive(userRolDTO.getActive());
        dto.setCreatedAt(userRolDTO.getCreatedAt());
        dto.setUser(userRolDTO.getUser());
        dto.setRol(userRolDTO.getRol());
        return dto;
    }
}
