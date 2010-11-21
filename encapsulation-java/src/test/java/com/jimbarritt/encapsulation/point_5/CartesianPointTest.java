package com.jimbarritt.encapsulation.point_5;

import org.junit.*;

import static com.jimbarritt.encapsulation.point_5.CalculationPrecision.*;
import static java.lang.String.format;
import static junit.framework.Assert.*;

public class CartesianPointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new CartesianPoint(10, 20);
        Point p2 = new CartesianPoint(20, 30);

        double distanceP1_P2 = p1.distanceTo(p2);
        double distanceP2_P1= p1.distanceTo(p2);

        assertEquals(14.14214, distanceP1_P2, 0.0001);
        assertEquals(14.14214, distanceP2_P1, 0.0001);
    }

    /**
     * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
     */
    @Test
    public void converts_to_polar_point() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        PolarPoint polarPoint = cartesianPoint.asPolarPoint();

        PolarPoint expectedPolarPoint = new PolarPoint(0.9827937, 36.0555128);
        assertTrue(format("(%s) should equal (%s)", polarPoint, expectedPolarPoint),
                   polarPoint.isEqualTo(expectedPolarPoint, sixDecimalPlaces));
    }

    @Test
    public void equality_and_identity() {
        CartesianPoint p1 = new CartesianPoint(20, 30);
        CartesianPoint p2 = new CartesianPoint(20, 30);
        CartesianPoint p3 = new CartesianPoint(10, 40);

        assertTrue(p1.equals(p2));
        assertTrue(p1.hashCode() == p2.hashCode());

        assertFalse(p1.equals(p3));
        assertFalse(p1.hashCode() == p3.hashCode());        
    }
}