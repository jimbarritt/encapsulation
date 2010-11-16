package com.jimbarritt.encapsulation.point_2;

import com.jimbarritt.encapsulation.point_2.Point;
import org.junit.*;

import static java.lang.Math.*;
import static junit.framework.Assert.*;

public class PointTest {

    /**
     * p1 = {10, 20}
     * p2 = {20, 30}
     * for p2, theta=0.9827937, r=36.0555128
     *
     * distance is = 14.14214
     */
    @Test
    public void calculates_the_distance_between_two_points() {
        Point p1 = new CartesianPoint(10, 20);
        Point p2 = new CartesianPoint(20, 30);
        Point p3 = new PolarPoint(0.9827937, 36.0555128);

        double distanceP1_P2 = p1.distanceTo(p2);
        double distanceP1_P3 = p1.distanceTo(p3);

        assertEquals(distanceP1_P2, distanceP1_P3, 0.0001);        
    }

}