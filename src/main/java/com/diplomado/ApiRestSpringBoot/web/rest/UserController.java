package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.*;
import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.domain.entities.User;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import com.diplomado.ApiRestSpringBoot.exception.ResourceNotFoundException;
import com.diplomado.ApiRestSpringBoot.exception.ServerResponseException;
import com.diplomado.ApiRestSpringBoot.exception.UserAlreadyExistsException;
import com.diplomado.ApiRestSpringBoot.services.UserDetailService;
import com.diplomado.ApiRestSpringBoot.services.UserRolService;
import com.diplomado.ApiRestSpringBoot.services.UserService;
import com.diplomado.ApiRestSpringBoot.services.mapper.UserDetailMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;
    private final UserRolService userRolService;

    private final UserDetailService userDetailService;
    private final UserDetailMapper userDetailMapper;


    public UserController(UserService userService, UserRolService userRolService,
                          UserDetailService userDetailService, UserDetailMapper userDetailMapper) {
        this.userService = userService;
        this.userRolService = userRolService;
        this.userDetailService = userDetailService;
        this.userDetailMapper = userDetailMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserShowDTO>> getUsers(@RequestParam(required = false, defaultValue = "false")
                                                          boolean detailed){
        if(detailed){
            return ResponseEntity.ok().body(userService.getUsersDetail());
        }else{
            return ResponseEntity.ok().body(userService.getUsers());
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserShowDTO> getUserById(@PathVariable final Long id){
        return ResponseEntity.ok().body(userService.getUserById(id)
                .orElseThrow(()->new ResourceNotFoundException("user","id",id)));
    }

    @PostMapping
    public ResponseEntity<UserShowDTO> saveUser(@Valid @RequestBody final UserRegisterDTO user) throws URISyntaxException {
        if( user.getId() != null ){
            throw new UserAlreadyExistsException("Id doesn't acept to created");

        }
        user.setCreatedAt(LocalDateTime.now());
        UserShowDTO userdb = new UserShowDTO();

        if(user.getUserDetail() != null){
             userdb= userService.saveUserAndDetail(user);
        }else{
             userdb= userService.save(user);
        }

        return ResponseEntity.created(new URI("/v1/users/"+userdb.getId() )).body(userdb);
    }
    @PostMapping("/rols")
    public ResponseEntity<UserShowDTO> saveUserWithRols(@Valid @RequestBody final UserRegisterDTO user) throws URISyntaxException {
        if( user.getId() != null ){
            throw new UserAlreadyExistsException("El usuario ya tiene una cuanta creada");
        }
        user.setCreatedAt(LocalDateTime.now());

       try {
           UserShowDTO userdb= userService.saveWithRols(user);
           return ResponseEntity.created(new URI("/v1/users/"+userdb.getId() )).body(userdb);
       }catch (Exception e){
            throw new ServerResponseException("El recurso no se creo por que el email es repetido u por problemas del servidor");
       }


    }

    @PutMapping("/{id}")
    public ResponseEntity<UserShowDTO> editRol(@PathVariable final Long id, @RequestBody final UserRegisterDTO user){
        if(id != user.getId()  || user.getId() == null){
            throw new UserAlreadyExistsException("Id not match or don't exist");
        }

        UserRegisterDTO nuevo = new UserRegisterDTO();
        nuevo.setId(user.getId());
        nuevo.setUsername(user.getUsername());
        nuevo.setPassword(user.getPassword());
        nuevo.setEmail(user.getEmail());
        UserShowDTO userdb = userService.save(nuevo);
        return ResponseEntity.ok().body(userdb);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteRol(@PathVariable final Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<UserShowDTO> updateCustomer(@PathVariable Long id, @RequestBody Map<String,Object> user) {
         UserShowDTO dto = userService.edit(id, user);
         return ResponseEntity.ok().body(dto);
    }


}
