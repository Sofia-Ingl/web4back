package com.example.web4back.util;

public class StatusObject {

    private String name;
    private boolean success;
    private String token;

    public StatusObject(boolean success, String token, String name) {
        this.success = success;
        this.token = token;
        this.name = name;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "StatusObject{" +
                "success=" + success +
                '}';
    }
}
