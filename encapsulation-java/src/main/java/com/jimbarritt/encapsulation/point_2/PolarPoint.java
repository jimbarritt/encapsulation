package com.jimbarritt.encapsulation.point_2;

import static java.lang.Math.*;

public class PolarPoint {

    private final int x;
    private final int y;

    public PolarPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(PolarPoint other) {
        int a = x - other.x;
        int b = y - other.y;
        return sqrt(pow(a, 2) + pow(b, 2));
    }
}