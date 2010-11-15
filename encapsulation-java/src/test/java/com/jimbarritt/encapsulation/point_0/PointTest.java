package com.jimbarritt.encapsulation.point_0;

import org.junit.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static junit.framework.Assert.assertEquals;

public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new Point();
        p1.x = 10;
        p1.y=20;

        Point p2 = new Point();
        p2.x = 20;
        p2.y = 30;

        double expectedDistance = sqrt(pow(20-10, 2) + pow(30-20, 2));

        Plane plane = new Plane();
        double actualDistance = plane.distanceBetween(p1, p2);

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }

}