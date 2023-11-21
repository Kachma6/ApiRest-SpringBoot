package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterMapper implements CustomMapper<UserRegisterDTO, User> {
    @Override
    public UserRegisterDTO toDto(User user) {
        UserRegisterDTO register = new UserRegisterDTO();
        register.setId(user.getId());
        register.setUsername(user.getUsername());
        register.setEmail(user.getEmail());
        register.setCreatedAt(user.getCreatedAt());
        register.setPassword(user.getPassword());
        register.setUserDetail(user.getUserDetail());
        return register;

    }

    @Override
    public User toEntity(UserRegisterDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setUserDetail(userDTO.getUserDetail());

        return user;
    }
}
