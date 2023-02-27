package com.example.catonsensp2.repositories;

import com.example.catonsensp2.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Override
    Optional<UserModel> findById(Long id);

    Optional<UserModel> findByUsername(String username);

//    List<UserModel> findByName(String name);
//
//    List<UserModel> findByPassword(String password);
//
//    List<UserModel> findByUserName(String username);

    Boolean existsByUsername(String username);
}
