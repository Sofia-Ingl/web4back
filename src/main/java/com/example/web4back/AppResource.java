package com.example.web4back;

import com.example.web4back.model.UserBean;
import com.example.web4back.service.EncryptingService;
import com.example.web4back.service.UserService;
import com.example.web4back.util.StatusObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AppResource {

    private final UserService userService;

    @Autowired
    public AppResource(UserService userService) {
        this.userService = userService;
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

    @PostMapping("/register")
    public ResponseEntity<StatusObject> tryRegister(@RequestBody UserBean rawUser) {
        UserBean encryptedUser = new UserBean(rawUser.getLogin(), EncryptingService.getEncodedPassword(rawUser.getPassword()));
        boolean success =  userService.register(encryptedUser);
        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<StatusObject> tryLogin(@RequestBody UserBean rawUser) {
        UserBean encryptedUser = new UserBean(rawUser.getLogin(), EncryptingService.getEncodedPassword(rawUser.getPassword()));
        boolean success = userService.login(encryptedUser);
        return new ResponseEntity<>(new StatusObject(success), HttpStatus.OK);
    }

}
