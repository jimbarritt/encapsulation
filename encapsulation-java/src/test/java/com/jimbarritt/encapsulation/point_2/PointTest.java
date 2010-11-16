package com.jimbarritt.encapsulation.point_2;

import com.jimbarritt.encapsulation.point_2.Point;
import org.junit.*;

import static java.lang.Math.*;
import static junit.framework.Assert.*;

public class PointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new CartesianPoint(10, 20);
        Point p2 = new CartesianPoint(20, 30);

        double expectedDistance = sqrt(pow(20-10, 2) + pow(30-20, 2));

        double actualDistance = p1.distanceTo(p2);

        assertEquals(expectedDistance, actualDistance, 0.0001);
    }

}