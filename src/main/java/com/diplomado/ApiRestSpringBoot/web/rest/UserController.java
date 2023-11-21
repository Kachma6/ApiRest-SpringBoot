package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.UserRegisterDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserShowDTO;
import com.diplomado.ApiRestSpringBoot.services.UserDetailService;
import com.diplomado.ApiRestSpringBoot.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserShowDTO>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserShowDTO> getUserById(@PathVariable final Long id){
        return ResponseEntity.ok().body(userService.getUserById(id)
                .orElseThrow(()->new IllegalArgumentException("No existe el registro")));
    }

    @PostMapping
    public ResponseEntity<UserShowDTO> saveUser(@RequestBody final UserRegisterDTO user) throws URISyntaxException {
        if( user.getId() != null ){
            throw new IllegalArgumentException("El rol ya tiene un id");

        }
        user.setCreatedAt(LocalDateTime.now());
        UserShowDTO userdb= userService.save(user);

        return ResponseEntity.created(new URI("/v1/users/"+userdb.getId() )).body(userdb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserShowDTO> editRol(@PathVariable final Long id, @RequestBody final UserRegisterDTO user){
        if(id != user.getId()  || user.getId() == null){
            throw new IllegalArgumentException("Id not match or don't exist");
        }
        UserShowDTO userdb = userService.save(user);
        return ResponseEntity.ok().body(userdb);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteRol(@PathVariable final Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
