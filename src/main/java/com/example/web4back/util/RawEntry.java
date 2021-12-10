package com.example.web4back.util;

public class RawEntry {

    private Double x;
    private Double y;
    private Double r;
    private String userName;

    public String getUserName() {
        return userName;
    }


    public Double getR() {
        return r;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "RawEntry{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", userName='" + userName + '\'' +
                '}';
    }
}
