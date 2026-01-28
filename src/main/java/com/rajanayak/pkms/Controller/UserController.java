package com.rajanayak.pkms.Controller;

import com.rajanayak.pkms.entity.User;
import com.rajanayak.pkms.service.UserService;
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
}
