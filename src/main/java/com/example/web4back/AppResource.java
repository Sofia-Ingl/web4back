package com.example.web4back;

import com.example.web4back.model.UserBean;
import com.example.web4back.security.jwt.JwtProvider;
import com.example.web4back.service.EncryptingService;
import com.example.web4back.service.UserService;
import com.example.web4back.util.StatusObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AppResource {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @Autowired
    public AppResource(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

//    @PostMapping("/register")
//    public ResponseEntity<StatusObject> tryRegister(@RequestParam(value = "login") String name,
//                                                    @RequestParam(value = "password") String password) {
//        UserBean encryptedUser = new UserBean(name, EncryptingService.getEncodedPassword(password));
//        boolean success =  userService.register(encryptedUser);
//        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<StatusObject> tryLogin(@RequestParam(value = "login") String name,
//                                                 @RequestParam(value = "password") String password) {
//        UserBean encryptedUser = new UserBean(name, EncryptingService.getEncodedPassword(password));
//        boolean success = userService.login(encryptedUser);
//        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
//    }


//    @PostMapping("/register")
//    public ResponseEntity<StatusObject> tryRegister(@RequestBody UserBean rawUser) {
//        UserBean encryptedUser = new UserBean(rawUser.getLogin(), EncryptingService.getEncodedPassword(rawUser.getPassword()));
//        boolean success =  userService.register(encryptedUser);
//        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<StatusObject> tryLogin(@RequestBody UserBean rawUser) {
//        UserBean encryptedUser = new UserBean(rawUser.getLogin(), EncryptingService.getEncodedPassword(rawUser.getPassword()));
//        boolean success = userService.login(encryptedUser);
//        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
//    }

    @GetMapping("/main/hell")
    public String test() {
        return "hello";
    }

    @PostMapping("/register")
    public StatusObject registerUser(@RequestBody UserBean user) {
        boolean status = userService.register(user);
        if (status) {
            String token = jwtProvider.generateToken(user.getLogin());
            return new StatusObject(true, token);
        }
        return new StatusObject(false, "");
    }

    @PostMapping("/auth")
    public StatusObject auth(@RequestBody UserBean user) {
        boolean status = userService.auth(user);
        if (status) {
            String token = jwtProvider.generateToken(user.getLogin());
            return new StatusObject(true, token);
        }
        return new StatusObject(false, "");
    }

}
