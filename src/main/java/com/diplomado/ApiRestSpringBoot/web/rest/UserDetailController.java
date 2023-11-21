package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.UserDetailDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
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
    @PostMapping
    public ResponseEntity<UserDetailDTO> createUserDetail(@RequestBody UserDetailDTO dto) throws URISyntaxException {
        if(dto.getId() != null){
            throw new IllegalArgumentException("El recurso ya tiene id");
        }
        UserDetailDTO userDetail1 = userDetailService.save(dto);
        return ResponseEntity.created(new URI("/v1/user-detail/"+userDetail1.getId())).body(userDetail1);
    }
}
