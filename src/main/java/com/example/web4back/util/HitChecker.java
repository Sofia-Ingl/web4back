package com.example.web4back.util;


import org.springframework.stereotype.Component;

@Component
public class HitChecker {

    public boolean checkIfHit(Double x, Double y, Double r) {
        return checkCircle(x, y, r) || checkRectangle(x, y, r) || checkTriangle(x, y, r);
    }

    private boolean checkRectangle(Double x, Double y, Double r) {
        return (x >= -r) && (y <= r) && (x <= 0) && (y >= 0);
    }

    private boolean checkTriangle(Double x, Double y, Double r) {
        return (x <= 0) && (y <= 0) && (y >= -x - r / 2);
    }

    private boolean checkCircle(Double x, Double y, Double r) {
        return (x >= 0) && (y >= 0) && (x * x + y * y <= r * r / 4);
    }
}
