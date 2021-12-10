package com.example.web4back.repository;

import com.example.web4back.model.EntryBean;
import com.example.web4back.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface EntryRepository extends JpaRepository<EntryBean, Long> {

    public List<EntryBean> findAllByUser(UserBean user);

}
