package com.jimbarritt.encapsulation.point_2;

import org.junit.*;

import static junit.framework.Assert.*;

public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);

        double actualDistance = p1.distanceTo(p2);

        assertEquals(14.14214, actualDistance, 0.0001);
    }

}