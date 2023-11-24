package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserRolDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserRolsDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.stereotype.Component;

@Component
public class UserRolsMapper implements CustomMapper<UserRolsDTO, UserRol>{
    @Override
    public UserRolsDTO toDto(UserRol userRol) {
        UserRolsDTO dto = new UserRolsDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreatedAt(userRol.getCreatedAt());
        dto.setUser(userRol.getUser());


        return dto;

    }

    @Override
    public UserRol toEntity(UserRolsDTO userRolsDTO) {
        UserRol dto = new UserRol();
        dto.setId(userRolsDTO.getId());
        dto.setActive(userRolsDTO.getActive());
        dto.setCreatedAt(userRolsDTO.getCreatedAt());
        dto.setUser(userRolsDTO.getUser());


        return dto;
    }
}
