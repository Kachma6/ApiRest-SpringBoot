package com.diplomado.ApiRestSpringBoot.web.rest;

import com.diplomado.ApiRestSpringBoot.DTO.RolDTO;
import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import com.diplomado.ApiRestSpringBoot.services.RolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/rols")
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> getRols(){
        return ResponseEntity.ok().body(rolService.getRols());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolsById(@PathVariable final Integer id){
        return ResponseEntity.ok().body(rolService.getRolById(id)
                .orElseThrow(()->new IllegalArgumentException("No existe el registro")));
    }

    @PostMapping
    public ResponseEntity<RolDTO> saveRol(@RequestBody final RolDTO rol) throws URISyntaxException {
        if( rol.getId()!= null ){
           throw new IllegalArgumentException("El rol ya tiene un id");

        }

        RolDTO roldb = rolService.save(rol);

        return ResponseEntity.created(new URI("/v1/rols/"+roldb.getId() )).body(roldb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@PathVariable final Integer id, @RequestBody final RolDTO rol){
        if(id != rol.getId()  || rol.getId() == null){
            throw new IllegalArgumentException("Id not match or don't exist");
        }
        RolDTO roldb = rolService.save(rol);
        return ResponseEntity.ok().body(roldb);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteRol(@PathVariable final Integer id){
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
