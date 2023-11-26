package com.diplomado.ApiRestSpringBoot.services.Implement;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import com.diplomado.ApiRestSpringBoot.repositories.UserDetailRepository;
import com.diplomado.ApiRestSpringBoot.repositories.UserRepository;
import com.diplomado.ApiRestSpringBoot.repositories.UserRolRepository;
import com.diplomado.ApiRestSpringBoot.services.UserService;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserRegisterMapper;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserShowMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserShowMapper userShowMapper;

    private final UserRegisterMapper userRegisterMapper;

 private final UserRolRepository userRolRepository;
    private final UserDetailRepository userDetailRepository;

    public UserServiceImpl(UserRepository userRepository, UserShowMapper userShowMapper, UserRegisterMapper userRegisterMapper, UserRolRepository userRolRepository, UserDetailRepository userDetailRepository) {
        this.userRepository = userRepository;
        this.userShowMapper = userShowMapper;
        this.userRegisterMapper = userRegisterMapper;
        this.userRolRepository = userRolRepository;
        this.userDetailRepository = userDetailRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<UserRegisterDTO> getUsers() {
        return userRepository.findAll().stream()
                .map(userRegisterMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserRegisterDTO> getUsersDetail() {
        return  userRepository.findAll().stream()
                .map(userRegisterMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserRegisterDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userRegisterMapper::toDtoDetailed);
    }

    @Override

    public UserRegisterDTO saveUserAndDetail(UserRegisterDTO user) {
        User userdb = userRepository.save(userRegisterMapper.toEntity(user));

////Generar una inconsistencia
//   Integer.parseInt(user.getUserDetail().getFirstName());

        if(user.getId() != null){
            UserDetail userDetail = new UserDetail();
            userDetail.setFirstName(user.getFirstName());
            userDetail.setId(user.getIduserDetail());
            userDetail.setLastName(user.getLastName());
            userDetail.setAge(user.getAge());
            userDetail.setBirthDay(user.getBirthDay());
            userDetail.setUser(userdb);

            userDetailRepository.save(userDetail);
        }else{
            userDetailRepository.save(new UserDetail(user.getFirstName(),
                    user.getLastName(),user.getAge(), user.getBirthDay(),userdb));
        }


        return userRegisterMapper.toDto(userdb);
    }

    @Override
    public UserRegisterDTO save(UserRegisterDTO dto) {
        User user= userRepository.save(userRegisterMapper.toEntity(dto));
        return userRegisterMapper.toDto(user);
    }
//    public UserShowDTO saveWithRols(UserRegisterDTO dto){
//        User userregistrer = new User();
//        userregistrer.setUsername(dto.getUsername());
//        userregistrer.setEmail(dto.getEmail());
//        userregistrer.setPassword(dto.getPassword());
//        userregistrer.setCreatedAt(dto.getCreatedAt());
//
//        User user = userRepository.save(userregistrer);
//        Set<UserRol> roles = dto.getUserRols();
//        for(UserRol rol: roles){
//            UserRol roldto = new UserRol();
//
//            Rol rolito = new Rol();
//            rolito.setId(rol.getId());
//
//            User user1 = new User();
//            user1.setId(user.getId());
//
//            roldto.setRol(rolito);
//            roldto.setUser(user1);
//
//            roldto.setActive(true);
//            roldto.setCreatedAt(LocalDateTime.now());
//            userRolRepository.save(roldto);
//        }
//        return userShowMapper.toDto(user);
//    }

    @Override
    public void delete(Long Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public UserShowDTO edit(Long id, Map<String, Object> fields) {
        User existingUser = userRepository.findById(id).get();


            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(User.class,key);
                field.setAccessible(true);
                ReflectionUtils.setField(field,existingUser,value);
            });
            return userShowMapper.toDto(userRepository.save(existingUser));


    }
}
