package com.example.web4back.service;

import com.example.web4back.model.UserBean;
import com.example.web4back.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserBean myUser = userRepository.findByLogin(userName);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: " + userName);
        }
        UserDetails usr = User.builder()
                .username(myUser.getLogin())
                .password(myUser.getPassword())
                .roles()
                .build();
        return usr;
    }
}