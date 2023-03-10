package com.example.catonsensp2.service;

import com.example.catonsensp2.models.UserModel;
import com.example.catonsensp2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAllUser(){
        return this.userRepository.findAll();
    }

    public Optional<UserModel> findUserByID(Long id){
        return this.userRepository.findById(id);
    }

    public List<UserModel> findUserByName(String name){
        List<UserModel> userList = userRepository.findByName(name);
        return userList;
    }

    public List<UserModel> findUserByTel(String tel){
        List<UserModel> userList = userRepository.findByTel(tel);
        return userList;
    }

    public List<UserModel> findUserByEmail(String email){
        List<UserModel> userList = userRepository.findByEmail(email);
        return userList;
    }

    public UserModel saveUser(UserModel user){
        return this.userRepository.save(user);
    }

    public Optional<UserModel> updateUser(Long id,UserModel newUser){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setName(newUser.getName());
            user.setOnsenAppoint(newUser.getOnsenAppoint());
            user.setMassageAppoint(newUser.getMassageAppoint());
            return userRepository.save(user);
        });
    }

    public void deleteByID(Long id){
        this.userRepository.deleteById(id);
    }
}
