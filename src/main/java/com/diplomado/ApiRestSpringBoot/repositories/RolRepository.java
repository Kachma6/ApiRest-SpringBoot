package com.diplomado.ApiRestSpringBoot.repositories;

import com.diplomado.ApiRestSpringBoot.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer > {
}
