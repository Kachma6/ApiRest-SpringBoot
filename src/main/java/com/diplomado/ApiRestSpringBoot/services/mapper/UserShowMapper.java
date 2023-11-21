package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserShowMapper implements CustomMapper<UserShowDTO, User>{
    @Override
    public UserShowDTO toDto(User user) {
        UserShowDTO showDTO = new UserShowDTO();
        showDTO.setId(user.getId());
        showDTO.setUsername(user.getUsername());
        showDTO.setEmail(user.getEmail());
        showDTO.setCreatedAt(user.getCreatedAt());
        return showDTO;
    }

    public UserShowDTO toDtoDetail(User user){
        UserShowDTO showDTO = new UserShowDTO();
        showDTO.setId(user.getId());
        showDTO.setUsername(user.getUsername());
        showDTO.setEmail(user.getEmail());
        showDTO.setCreatedAt(user.getCreatedAt());
        showDTO.setUserDetail(user.getUserDetail());
        if(!user.getUserRols().isEmpty()){
            Set<String>roles = new HashSet<>();
            ArrayList<UserRol> rols = new ArrayList<>(user.getUserRols());
            for(int i=0; i< user.getUserRols().size();i++){
                roles.add(rols.get(i).getRol().getName());
            }
            showDTO.setUserRolsNames(roles);
        }


        return showDTO;
    }
    @Override
    public User toEntity(UserShowDTO userShowDTO) {
        User entity = new User();
        entity.setUsername(userShowDTO.getUsername());
        entity.setEmail(userShowDTO.getEmail());
        entity.setId(userShowDTO.getId());
       entity.setCreatedAt(userShowDTO.getCreatedAt());
        return null;
    }
}
