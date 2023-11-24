package com.diplomado.ApiRestSpringBoot.repositories;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolRepository extends JpaRepository<UserRol,Integer> {
    UserRol findUserRolByUser_IdAndRol_Id(Long userId, Integer rolId);
}
