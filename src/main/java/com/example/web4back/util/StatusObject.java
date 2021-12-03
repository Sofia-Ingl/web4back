package com.example.web4back.util;

public class StatusObject {

    boolean success;

    public StatusObject(boolean success) {
        this.success = success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "StatusObject{" +
                "success=" + success +
                '}';
    }
}
