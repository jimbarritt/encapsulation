package com.jimbarritt.encapsulation.point_3;

import static java.lang.Math.*;
import static java.lang.String.format;

public class CartesianPoint implements Point {

    private final int x;
    private final int y;

    public CartesianPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point other) {
        CartesianPoint cartesianOther = other.asCartesianPoint();
        int a = x - cartesianOther.x;
        int b = y - cartesianOther.y;
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    public CartesianPoint asCartesianPoint() {
        return this;
    }

    public String toString() {
        return format("x=%d, y=%d", x, y);
    }
}