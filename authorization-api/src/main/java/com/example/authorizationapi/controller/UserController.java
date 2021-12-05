package com.example.authorizationapi.controller;

import com.example.authorizationapi.model.User;
import com.example.authorizationapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password) {
        return userService.getPermissions(username, password);
    }

    @GetMapping("")
    public List<User> getAllUser() {
        return userService.getUserList();
    }

}
