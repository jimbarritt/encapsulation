package com.jimbarritt.encapsulation.point_1;

import org.junit.*;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static junit.framework.Assert.assertEquals;

public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);

        double expectedDistance = sqrt(pow(20-10, 2) + pow(30-20, 2));

        double actualDistance = p1.distanceTo(p2);

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }

}