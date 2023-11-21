package com.diplomado.ApiRestSpringBoot.services.Implement;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.repositories.UserDetailRepository;
import com.diplomado.ApiRestSpringBoot.services.UserDetailService;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserDetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    private final UserDetailRepository userDetailRepository;

    private final UserDetailMapper userDetailMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }


    @Override
    public List<UserDetailDTO> getUserDetail() {
        return userDetailRepository.findAll().stream().map(userDetailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDetailDTO> getUserDetailById(Integer id) {
        return userDetailRepository.findById(id).map(userDetailMapper::toDto);
    }

    @Override
    public UserDetailDTO save(UserDetailDTO dto) {
        return userDetailMapper.toDto( userDetailRepository.save(userDetailMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer Id) {
        userDetailRepository.deleteById(Id);
    }
}
