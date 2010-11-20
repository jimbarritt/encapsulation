package com.jimbarritt.encapsulation.point_4;

import static java.lang.Math.*;

public class PolarPoint implements Point {

    final double theta;
    final double rho;

    public PolarPoint(double theta, double rho) {
        this.theta = theta;
        this.rho = rho;
    }

    public double distanceTo(Point other) {
        CartesianPoint thisPoint = asCartesianPoint();
        return thisPoint.distanceTo(other);
    }

    public boolean isEqualTo(PolarPoint other, CalculationPrecision precision) {
        return precision.isEqual(this.rho, other.rho()) 
            && precision.isEqual(this.theta, other.theta());
    }

    public double rho() {
        return rho;
    }

    private double theta() {
        return theta;
    }

    public CartesianPoint asCartesianPoint() {
        int x = (int)round((rho * cos(theta)));
        int y = (int)round(rho * sin(theta));
        return new CartesianPoint(x, y);
    }



}