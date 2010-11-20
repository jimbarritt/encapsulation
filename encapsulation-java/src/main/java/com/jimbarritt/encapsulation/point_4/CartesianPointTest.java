package com.jimbarritt.encapsulation.point_4;

import org.junit.*;

import static com.jimbarritt.encapsulation.point_4.CalculationPrecision.*;
import static junit.framework.Assert.*;

public class CartesianPointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new CartesianPoint(10, 20);
        Point p2 = new CartesianPoint(20, 30);

        double distanceP1_P2 = p1.distanceTo(p2);
     
        assertEquals(14.14214, distanceP1_P2, 0.0001);
    }

    /**
     * r = √ (x2 + y2)
     * θ = atan( y / x )
     *
     * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
     */
    @Test
    public void converts_to_polar_point() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        PolarPoint polarPoint = cartesianPoint.asPolarPoint();

        PolarPoint expectedPolarPoint = new PolarPoint(0.9827937, 36.0555128);
        assertTrue(polarPoint.isEqualTo(expectedPolarPoint, sixDecimalPlaces));
    }
}