package com.jimbarritt.encapsulation.point_4;

import static com.jimbarritt.encapsulation.point_4.Radians.*;
import static java.lang.Math.*;
import static java.lang.String.*;

/**
 * http://mathworld.wolfram.com/PolarCoordinates.html
 */
public class PolarPoint implements Point {

    final Radians theta;
    final double r;

    public PolarPoint(double theta, double r) {
        this(radians(theta), r);
    }

    public PolarPoint(Radians theta, double r) {
        this.theta = theta;
        this.r = r;
    }

    public double distanceTo(Point other) {
        CartesianPoint thisPoint = asCartesianPoint();
        return thisPoint.distanceTo(other);
    }

    public boolean isEqualTo(PolarPoint other, CalculationPrecision precision) {
        return precision.isEqual(r, other.r)
                && theta.isEqual(other.theta, precision);
    }


    public CartesianPoint asCartesianPoint() {
        int x = (int)round((r * theta.cos()));
        int y = (int)round(r * theta.sin());
        return new CartesianPoint(x, y);
    }

    public String toString() {
        return format("theta=%s, rho=%.7f", theta, r);
    }
}