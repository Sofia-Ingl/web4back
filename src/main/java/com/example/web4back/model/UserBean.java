package com.example.web4back.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserBean implements Serializable {

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "USER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private String login;
    private String password;

    public UserBean() {
    }

    public UserBean(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    public void setPassword(String hashedPass) {
        this.password = hashedPass;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + login + '\'' +
                ", pass='" + password + '\'' +
                '}';
    }
}
