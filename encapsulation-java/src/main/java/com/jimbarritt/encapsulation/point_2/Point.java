package com.jimbarritt.encapsulation.point_2;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }    

    public double distanceTo(Point other) {
        int a = x - other.x;
        int b = y - other.y;
        return sqrt(pow(a, 2) + pow(b, 2));
    }
}