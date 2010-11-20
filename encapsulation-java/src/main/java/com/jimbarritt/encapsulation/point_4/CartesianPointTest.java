package com.jimbarritt.encapsulation.point_4;

import org.junit.*;

import static junit.framework.Assert.*;

public class CartesianPointTest {

    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new CartesianPoint(10, 20);
        Point p2 = new CartesianPoint(20, 30);

        double distanceP1_P2 = p1.distanceTo(p2);
     
        assertEquals(14.14214, distanceP1_P2, 0.0001);
    }
}