package com.example.catonsensp2.repositories;


import com.example.catonsensp2.models.OnsenImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OnsenImageRepository extends JpaRepository<OnsenImageModel, Long> {

    @Override
    Optional<OnsenImageModel> findById(Long aLong);
}
