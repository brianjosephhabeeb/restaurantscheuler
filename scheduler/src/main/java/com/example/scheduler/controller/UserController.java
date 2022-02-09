package com.example.scheduler.controller;

import com.example.scheduler.model.Request.LoginRequest;
import com.example.scheduler.model.User;
import com.example.scheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public User createUser(@RequestBody User userObject){
        return userService.createUser(userObject);
    }

    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }


}
