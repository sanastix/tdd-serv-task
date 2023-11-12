package com.example.tddservtask.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculator {

    private final double a = 2.3;
    private final double EPS = 1e-3;

    private double x;

    public double getY(){

        double y;

        if (x <= 0.3+EPS){
            y = 1.5 * a * Math.pow(Math.cos(x), 2);
        } else if (x > 0.3 && x <= 2.3+EPS) {
            y = Math.pow((x - 2), 2) + 6 * a;
        } else {
            y = 3 * a * Math.tan(x);
        }

        return y;
    }

}
