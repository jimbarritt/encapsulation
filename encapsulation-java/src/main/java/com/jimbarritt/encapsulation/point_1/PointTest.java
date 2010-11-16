package com.jimbarritt.encapsulation.point_1;

import org.junit.*;

import static junit.framework.Assert.assertEquals;


public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);

        Plane plane = new Plane();
        double actualDistance = plane.distanceBetween(p1, p2);

        assertEquals(14.14214, actualDistance, 0.0001);
    }

}