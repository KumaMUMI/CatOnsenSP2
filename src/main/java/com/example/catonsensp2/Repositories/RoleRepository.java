package com.example.catonsensp2.Repositories;

import com.example.catonsensp2.Models.ERole;
import com.example.catonsensp2.Models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long> {
    Optional<RoleModel> findByName(ERole name);
}
