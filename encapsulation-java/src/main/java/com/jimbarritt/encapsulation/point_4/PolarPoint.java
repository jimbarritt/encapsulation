package com.jimbarritt.encapsulation.point_4;

import static com.jimbarritt.encapsulation.point_4.Radians.*;
import static java.lang.Math.*;
import static java.lang.String.*;

public class PolarPoint implements Point {

    final Radians theta;
    final double rho;

    public PolarPoint(Radians theta, double rho) {
        this.theta = theta;
        this.rho = rho;
    }

    public PolarPoint(double theta, double rho) {
        this(radians(theta), rho);
    }

    public double distanceTo(Point other) {
        CartesianPoint thisPoint = asCartesianPoint();
        return thisPoint.distanceTo(other);
    }

    public boolean isEqualTo(PolarPoint other, CalculationPrecision precision) {
        return precision.isEqual(rho, other.rho())
                && theta.isEqual(other.theta(), precision);
    }

    public double rho() {
        return rho;
    }

    public Radians theta() {
        return theta;
    }

    public CartesianPoint asCartesianPoint() {
        int x = (int)round((rho * theta.cos()));
        int y = (int)round(rho * theta.sin());
        return new CartesianPoint(x, y);
    }

    public String toString() {
        return format("theta=%s, rho=%.7f", theta, rho);
    }
}