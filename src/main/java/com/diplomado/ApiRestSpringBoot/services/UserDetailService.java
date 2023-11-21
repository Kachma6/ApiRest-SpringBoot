package com.diplomado.ApiRestSpringBoot.services;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {
    List<UserDetailDTO> getUserDetail();

    Optional<UserDetailDTO> getUserDetailById(Integer id);

   UserDetailDTO save(UserDetailDTO dto);

    void delete(Integer Id);
}
