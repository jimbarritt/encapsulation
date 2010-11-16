package com.jimbarritt.encapsulation.point_2;

import static java.lang.Math.cos;
import static java.lang.Math.round;
import static java.lang.Math.sin;

public class PolarPoint implements Point {

    final double theta;
    final double r;

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