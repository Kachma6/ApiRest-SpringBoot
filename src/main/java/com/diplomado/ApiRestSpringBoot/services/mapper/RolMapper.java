package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.RolDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol> {
    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO  = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
       rolDTO.setUserRols(rol.getUserRols());
        return rolDTO;
    }
    public RolDTO toShowDto(Rol rol) {
        RolDTO rolDTO  = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());


        if(!rol.getUserRols().isEmpty()) {
            Set<String> roles = new HashSet<>();
            ArrayList<UserRol> rols = new ArrayList<>(rol.getUserRols());
            for (int i = 0; i < rol.getUserRols().size(); i++) {
                roles.add(rols.get(i).getUser().getUsername());
            }
            rolDTO.setListRols(roles);
        }
        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
   rol.setUserRols(rolDTO.getUserRols());
        return rol;
    }
}
