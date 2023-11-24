package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import com.diplomado.ApiRestSpringBoot.exception.ResourceNotFoundException;
import com.diplomado.ApiRestSpringBoot.repositories.UserDetailRepository;
import com.diplomado.ApiRestSpringBoot.services.UserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/user-detail")
public class UserDetailController {
    private final UserDetailService userDetailService;

    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }
    @GetMapping
    public ResponseEntity<List<UserDetailDTO>> getUserDetail(){
        return ResponseEntity.ok().body(userDetailService.getUserDetail());

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUserDetailById(@PathVariable Integer id){
        return ResponseEntity.ok().body(userDetailService.getUserDetailById(id)
                .orElseThrow(()-> new IllegalArgumentException("No existe ningun recurso con ese id")));

    }
    @GetMapping("/by-user/{userId}")
    public ResponseEntity<UserDetailDTO> getUserDetailByIdUser(@PathVariable Long userId){
        return ResponseEntity.ok().body(userDetailService.getUserDetailByIdUser(userId)
                .orElseThrow(()-> new ResourceNotFoundException("UserDetail", "idUser",userId)));

    }
    @PostMapping
    public ResponseEntity<UserDetailDTO> createUserDetail(@RequestBody UserDetailDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("El recurso ya tiene id");
        }
        UserDetailDTO userDetail1 = userDetailService.save(dto);
        return ResponseEntity.created(new URI("/v1/user-detail/"+userDetail1.getId())).body(userDetail1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        userDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
