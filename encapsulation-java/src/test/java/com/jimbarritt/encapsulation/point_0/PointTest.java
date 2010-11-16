package com.jimbarritt.encapsulation.point_0;

import org.junit.*;

import static junit.framework.Assert.*;

public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new Point();
        p1.x = 10;
        p1.y = 20;

        Point p2 = new Point();
        p2.x = 20;
        p2.y = 30;

        Plane plane = new Plane();
        double actualDistance = plane.distanceBetween(p1, p2);

        assertEquals(14.14214, actualDistance, 0.0001);
    }

}