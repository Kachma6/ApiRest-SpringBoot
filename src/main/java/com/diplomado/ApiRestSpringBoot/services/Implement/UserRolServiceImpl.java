package com.diplomado.ApiRestSpringBoot.services.Implement;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserRolDTO;
import com.diplomado.ApiRestSpringBoot.repositories.UserRolRepository;
import com.diplomado.ApiRestSpringBoot.services.UserRolService;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {

    private final UserRolRepository userRolRepository;
    private final UserRolMapper userRolMapper;

    public UserRolServiceImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> getUserRol() {
        return (userRolRepository.findAll().stream()
                .map(userRolMapper::toDto).collect(Collectors.toList()));
    }

    @Override
    public Optional<UserRolDTO> getUserRolById(Integer id) {

        return userRolRepository.findById(id).map(userRolMapper::toDto);
    }

    @Override
    public UserRolDTO save(UserRolDTO dto) {
        return userRolMapper.toDto( userRolRepository.save(userRolMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer Id) {
        userRolRepository.deleteById(Id);
    }

    @Override
    public UserRolDTO unsuscribeRol(Integer rolId, Long userId) {
        UserRolDTO edit = userRolMapper.toDto(userRolRepository.findUserRolByUser_IdAndRol_Id(userId,rolId));
        edit.setActive(false);
        UserRolDTO edited = userRolMapper.toDto(userRolRepository.save(userRolMapper.toEntity(edit)));
        return edited ;
    }


}
