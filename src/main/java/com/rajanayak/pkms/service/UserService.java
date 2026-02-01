package com.rajanayak.pkms.service;

import com.rajanayak.pkms.entity.User;
import com.rajanayak.pkms.repository.IUserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    //This method is used to find a user from the collection based on the id
    public Optional<User> getUserById(String id){
        if (!ObjectId.isValid(id)) {
            throw new IllegalArgumentException("Invalid MongoDB ObjectId: " + id);
        }
        return userRepo.findById(new ObjectId(id));
    }

    //This method is used to find the User based on his Name
    public Optional<User> getUserByName(String userName){
        return userRepo.findUserByUsername(userName);
    }

    //This method gives the specific user details based on his Email
    public Optional<User> getUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    //This methods will find the User Based on Both name and email
    public Optional<User> getByNameAndEmail(String name, String mail){
        return userRepo.findByUserNameAndEmail(name, mail);
    }
}
