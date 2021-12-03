package com.example.web4back.service;

import com.example.web4back.model.UserBean;
import com.example.web4back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    private UserBean addUser(UserBean user) {
        return userRepository.save(user);
    }

    private boolean checkUserInDB(UserBean user) {
        Example<UserBean> userExample = Example.of(user);
        return userRepository.exists(userExample);
    }

    public boolean register(UserBean user) {
        boolean alreadyInDB = checkUserInDB(new UserBean(user.getLogin(), null));
        System.out.println("Register: " + !alreadyInDB);
        System.out.println(user);
        if (alreadyInDB) return false;
        addUser(user);
        return true;
    }

    public boolean login(UserBean user) {
        boolean matches = checkUserInDB(user);
        System.out.println("Login: " + matches);
        System.out.println(user);
        return matches;
    }
}
