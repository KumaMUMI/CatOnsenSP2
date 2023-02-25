package com.example.catonsensp2.repositories;

import com.example.catonsensp2.models.ERole;
import com.example.catonsensp2.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long> {
    Optional<RoleModel> findByName(ERole name);
}
