package com.diplomado.ApiRestSpringBoot.repositories;

import com.diplomado.ApiRestSpringBoot.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Integer> {
    UserDetail findByUser_Id(Long userId);
}
