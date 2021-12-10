package com.example.web4back.controllers;

import com.example.web4back.model.UserBean;
import com.example.web4back.security.jwt.JwtProvider;
import com.example.web4back.service.UserService;
import com.example.web4back.util.StatusObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    public UserController(@Autowired UserService userService, @Autowired JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public StatusObject registerUser(@RequestBody UserBean user) {
        boolean status = userService.register(user);
        if (status) {
            String token = jwtProvider.generateToken(user.getLogin());
            return new StatusObject(true, token, user.getLogin());
        }
        return new StatusObject(false, "", user.getLogin());
    }

    @PostMapping("/auth")
    public StatusObject auth(@RequestBody UserBean user) {
        boolean status = userService.auth(user);
        if (status) {
            String token = jwtProvider.generateToken(user.getLogin());
            return new StatusObject(true, token, user.getLogin());
        }
        return new StatusObject(false, "", user.getLogin());
    }
}
