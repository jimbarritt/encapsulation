package com.jimbarritt.encapsulation.point_2;

public class PolarPoint implements Point {

    final double theta;
    final double r;

    public PolarPoint(double theta, double r) {
        this.theta = theta;
        this.r = r;
    }

    public double distanceTo(Point other) {
        return 0;
    }

    public CartesianPoint asCartesianPoint() {
        return null;
    }
}