package com.diplomado.ApiRestSpringBoot.services.Implement;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import com.diplomado.ApiRestSpringBoot.repositories.UserRepository;
import com.diplomado.ApiRestSpringBoot.services.UserService;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserRegisterMapper;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserShowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserShowMapper userShowMapper;

    private final UserRegisterMapper userRegisterMapper;

    public UserServiceImpl(UserRepository userRepository, UserShowMapper userShowMapper, UserRegisterMapper userRegisterMapper) {
        this.userRepository = userRepository;
        this.userShowMapper = userShowMapper;
        this.userRegisterMapper = userRegisterMapper;
    }

    @Override
    public List<UserShowDTO> getUsers() {
        return userRepository.findAll().stream().map(userShowMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserShowDTO> getUsersDetail() {
        return null;
    }

    @Override
    public Optional<UserShowDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userShowMapper::toDto);
    }

    @Override
    public UserShowDTO save(UserRegisterDTO dto) {
        User user= userRepository.save(userRegisterMapper.toEntity(dto));
        return userShowMapper.toDto(user);
    }

    @Override
    public void delete(Long Id) {
        userRepository.deleteById(Id);
    }
}
