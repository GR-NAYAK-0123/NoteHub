package com.rajanayak.pkms.service;

import com.rajanayak.pkms.entity.User;
import com.rajanayak.pkms.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepo;

    //This method get all the records from the users Collections
    public Iterable<User> getAllUser(){
        return userRepo.findAll();
    }

    //This method save one User to the users collection
    public void saveOneUser(User newUser){
        userRepo.save(newUser);
    }
}
