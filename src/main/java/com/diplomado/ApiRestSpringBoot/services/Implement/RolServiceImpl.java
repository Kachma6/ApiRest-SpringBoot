package com.diplomado.ApiRestSpringBoot.services.Implement;

import com.diplomado.ApiRestSpringBoot.DTO.RolDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.repositories.RolRepository;
import com.diplomado.ApiRestSpringBoot.services.RolService;
import com.diplomado.ApiRestSpringBoot.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> getRols() {
        return rolRepository.findAll().stream()
                .map(rolMapper::toShowDto).collect(Collectors.toList());
    }

    @Override
    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }

    @Override
    public RolDTO save(RolDTO dto) {
        return rolMapper.toDto(rolRepository.save(rolMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer Id) {
        rolRepository.deleteById(Id);
    }
}
