package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.UserRolDTO;
import com.diplomado.ApiRestSpringBoot.DTO.UserRolsDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import com.diplomado.ApiRestSpringBoot.services.UserRolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/users-rols")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }


    @GetMapping()
    public ResponseEntity<List<UserRolDTO>> getAll(){
        return ResponseEntity.ok().body(userRolService.getUserRol());
    }
    @PostMapping
    public ResponseEntity<UserRolDTO> create(@Valid @RequestBody UserRolDTO userRol) throws URISyntaxException {
        if (userRol.getId() != null){
            throw new IllegalArgumentException("El archivo ya contiene un id");
        }
        userRol.setCreatedAt(LocalDateTime.now());
        UserRolDTO userRol1 = userRolService.save(userRol);
        return ResponseEntity.created(new URI("/v1/users-rols/"+ userRol1.getId())).body(userRol1);
    }
    @PostMapping("/detailed")
    public ResponseEntity<UserRolsDTO> createWithRolss(@Valid @RequestBody UserRolsDTO userRol) throws URISyntaxException {
        if (userRol.getId() != null){
            throw new IllegalArgumentException("El archivo ya contiene un id");
        }


        for (int i = 0; i< userRol.getRols().size();i++){
            UserRolDTO registro = new UserRolDTO();
            registro.setActive(userRol.getActive());
            registro.setUser(userRol.getUser());
            registro.setCreatedAt(LocalDateTime.now());
            registro.setRol(userRol.getRols().get(i));
            userRolService.save(registro);
        }
//        UserRolDTO userRol1 = userRolService.save(userRol);
        return ResponseEntity.ok().body(userRol);
    }

    @PatchMapping("/{userId}/{rolId}")
    public ResponseEntity<UserRolDTO> getUserRolByUserAndRol(@PathVariable Long userId,@PathVariable Integer rolId){
        return ResponseEntity.ok().body(userRolService.unsuscribeRol(rolId,userId));
    }

}
