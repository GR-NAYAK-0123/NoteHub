package com.rajanayak.pkms.controller;

import com.rajanayak.pkms.dto.user.UpdateUser;
import com.rajanayak.pkms.entity.User;
import com.rajanayak.pkms.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> gettingAllUser(){
        return (List<User>)userService.getAllUser();
    }

    @PostMapping
    public void saveOneUser(@RequestBody User newUser){
        userService.saveOneUser(newUser);
    }

    @GetMapping("/{myId}")
    public User gettingUserById(@PathVariable String myId){
        return userService.getUserById(myId).
                orElseThrow(() -> new IllegalArgumentException("User is not found : "+myId));
    }

    @GetMapping("/username/{userName}")
    public User gettingUserByName(@PathVariable String userName){
        return userService.getUserByName(userName)
                .orElseThrow(() -> new IllegalArgumentException("User not found with UserName : "+userName));
    }

    @GetMapping("/Email/{email}")
    public User gettingUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found with email : "+email));
    }

    @GetMapping("/Name/Email/{name}/{email}")
    public User GettingUserByNameAndEmail(@PathVariable String name, @PathVariable String email){
        return userService.getByNameAndEmail(name, email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Details : "));
    }

    @PutMapping("/{id}")
    public User updateUserData(@PathVariable String id, @RequestBody UpdateUser user){
        return userService.modifyUserData(id, user);
    }
}
