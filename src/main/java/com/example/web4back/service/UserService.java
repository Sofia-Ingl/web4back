package com.example.web4back.service;

import com.example.web4back.model.UserBean;
import com.example.web4back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    private void saveUser(UserBean user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    private UserBean findByLoginAndPassword(String login, String password) {
        UserBean user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public UserBean findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public boolean register(UserBean user) {
        boolean alreadyInDB = (findByLogin(user.getLogin()) != null);
        System.out.println("Register: " + !alreadyInDB);
        System.out.println(user);
        if (alreadyInDB) return false;
        saveUser(user);
        return true;
    }

    public boolean auth(UserBean user) {
        boolean matches = (findByLoginAndPassword(user.getLogin(), user.getPassword()) != null);
        System.out.println("Login: " + matches);
        System.out.println(user);
        return matches;
    }

    public UserBean getById(Long id) {
        Optional<UserBean> userBean = userRepository.findById(id);
        return userBean.orElse(null);
    }


//
//    private boolean checkUserInDB(UserBean user) {
//        Example<UserBean> userExample = Example.of(user);
//        return userRepository.exists(userExample);
//    }
//
//    public boolean register(UserBean user) {
//        boolean alreadyInDB = checkUserInDB(new UserBean(user.getLogin(), null));
//        System.out.println("Register: " + !alreadyInDB);
//        System.out.println(user);
//        if (alreadyInDB) return false;
//        addUser(user);
//        return true;
//    }
//
//    public boolean login(UserBean user) {
//        boolean matches = checkUserInDB(user);
//        System.out.println("Login: " + matches);
//        System.out.println(user);
//        return matches;
//    }
}
