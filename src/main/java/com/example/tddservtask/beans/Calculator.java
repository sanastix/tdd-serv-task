package com.example.tddservtask.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculator {

    private double a = 2.3;
    private double start = 0.2;
    private double end = 2.8;
    private double step = 0.002;
    private final double EPS = 1e-3;

    private double x;

    public Calculator(double x) {
        this.x = x;
    }

    public double getY(){
        return function(x);
    }

    public String getTable(){
        double[] xArr = fillX(start, end, step);
        double[] yArr = fillY(xArr);
        return generateHtmlTable(xArr,yArr);
    }

    private double function(double x){

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

    private String generateHtmlTable(double[] xArr, double[] yArr) {
        StringBuilder htmlTable = new StringBuilder();
        htmlTable.append("<table border=\"1\">");
        htmlTable.append("<tr><th>x</th><th>y</th></tr>");
        for (int i = 0; i < xArr.length; i++) {
            htmlTable.append("<tr><td>").append(xArr[i]).append("</td><td>").append(yArr[i]).append("</td></tr>");
        }
        htmlTable.append("</table>");
        return htmlTable.toString();
    }

    private double[] fillX (double start, double end, double step){
        int n = calculateSteps(start, end, step);
        return IntStream.range(0, n).mapToDouble(i -> start + i * step).map(Calculator::roundToThree).toArray();
    }

    private double[] fillY(double[] x){
        return Arrays.stream(x).map(this::function).map(Calculator::roundToThree).toArray();
    }

    private static double roundToThree(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }

    private int calculateSteps(double start, double end, double step) {
        return (int) Math.round((end - start) / step + 1);
    }

}
