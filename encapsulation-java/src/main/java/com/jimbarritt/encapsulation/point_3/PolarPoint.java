package com.jimbarritt.encapsulation.point_3;

import static java.lang.Math.*;

public class PolarPoint implements Point {

    private final double theta;
    private final double r;

    public PolarPoint(double theta, double r) {
        this.theta = theta;
        this.r = r;
    }

    public double distanceTo(Point other) {
        CartesianPoint thisPoint = asCartesianPoint();
        return thisPoint.distanceTo(other);
    }

    public CartesianPoint asCartesianPoint() {
        int x = (int)round((r * cos(theta)));
        int y = (int)round(r * sin(theta));
        return new CartesianPoint(x, y);
    }
}