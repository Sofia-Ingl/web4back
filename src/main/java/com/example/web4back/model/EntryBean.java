package com.example.web4back.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class EntryBean implements Serializable {

    @Id
    @SequenceGenerator(name = "entrySeq", sequenceName = "ENTRY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entrySeq")
    @Column(updatable = false, nullable = false)
    private Long id;
    private Double x;
    private Double y;
    private Double r;
    private Boolean isHit;

    @ManyToOne
    private UserBean user;

    public EntryBean() {

    }

    public EntryBean(Double x, Double y, Double r, Boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public Double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    public Double getR() {
        return r;
    }

    public Boolean getHit() {
        return isHit;
    }

    public Long getId() {
        return id;
    }

    public UserBean getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void setHit(Boolean hit) {
        isHit = hit;
    }

    @Override
    public String toString() {
        return "EntryBean{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", isHit=" + isHit +
                ", user=" + user +
                '}';
    }
}
