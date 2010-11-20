package com.jimbarritt.encapsulation.point_5;

import static java.lang.Math.*;
import static java.lang.String.*;

/**
 * http://mathworld.wolfram.com/CartesianCoordinates.html
 */
public class CartesianPoint implements Point {

    private final int x;
    private final int y;

    private final PointConverter pointConverter;

    public CartesianPoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.pointConverter = new PointConverter();
    }

    public double distanceTo(Point other) {
        CartesianPoint cartesianOther = pointConverter.asCartesianPoint(other);
        int a = x - cartesianOther.x;
        int b = y - cartesianOther.y;
        return calculateHypotenuseFor(a, b);
    }

    public void accept(PointVisitor pointVisitor) {
        pointVisitor.visit(this);
    }

    /**
     * r = √ (x^2 + y^2)
     * θ = atan( y / x )
     */
    public PolarPoint asPolarPoint() {
        double theta = atan2(y , x);
        double r = calculateHypotenuseFor(x, y);
        return new PolarPoint(theta, r);
    }

    public CartesianPoint asCartesianPoint() {
        return this;
    }

    public String toString() {
        return format("x=%d, y=%d", x, y);
    }

    private static double calculateHypotenuseFor(int a, int b) {
        return sqrt(pow(a, 2) + pow(b, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartesianPoint that = (CartesianPoint) o;

        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}