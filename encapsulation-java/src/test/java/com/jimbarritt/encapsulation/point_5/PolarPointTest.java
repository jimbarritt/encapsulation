package com.jimbarritt.encapsulation.point_5;

import org.junit.*;

import static junit.framework.Assert.*;

public class PolarPointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        PolarPoint p1 = new PolarPoint(1.107149, 22.360680);
        PolarPoint p2 = new PolarPoint(0.9827937, 36.0555128);

        double distanceP1_P2 = p1.distanceTo(p2);
        double distanceP2_P1 = p2.distanceTo(p1);

        assertEquals(14.14214, distanceP1_P2, 0.0001);
        assertEquals(14.14214, distanceP2_P1, 0.0001);
    }

    @Test
    public void converts_to_cartesian() {
        PolarPoint p1 = new PolarPoint(0.9827937, 36.0555128);

        CartesianPoint p2 = p1.asCartesianPoint();

        assertEquals(p2.toString(), "x=20, y=30");
    }
}