package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserShowMapper implements CustomMapper<UserShowDTO, User>{
    @Override
    public UserShowDTO toDto(User user) {
        UserShowDTO showDTO = new UserShowDTO();
        showDTO.setId(user.getId());
        showDTO.setUsername(user.getUsername());
        showDTO.setEmail(user.getEmail());
        showDTO.setCreatedAt(user.getCreatedAt());
       showDTO.setUserDetail(user.getUserDetail());
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
