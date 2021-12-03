package com.example.web4back.repository;

import com.example.web4back.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserBean, Long> {
}
