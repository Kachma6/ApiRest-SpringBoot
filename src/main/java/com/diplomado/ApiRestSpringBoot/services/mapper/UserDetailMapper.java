package com.diplomado.ApiRestSpringBoot.services.mapper;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail>{
    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        UserDetailDTO dto = new UserDetailDTO();
        dto.setId(userDetail.getId());
        dto.setFirstName(userDetail.getFirstName());
        dto.setLastName(userDetail.getLastName());
        dto.setAge(userDetail.getAge());
        dto.setBirthDay(userDetail.getBirthDay());
        dto.setUser(userDetail.getUser());
        return dto;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO userDetailDTO) {
        UserDetail dto = new UserDetail();
        dto.setId(userDetailDTO.getId());
        dto.setFirstName(userDetailDTO.getFirstName());
        dto.setLastName(userDetailDTO.getLastName());
        dto.setAge(userDetailDTO.getAge());
        dto.setBirthDay(userDetailDTO.getBirthDay());
       dto.setUser(userDetailDTO.getUser());
        return dto;
    }
}
