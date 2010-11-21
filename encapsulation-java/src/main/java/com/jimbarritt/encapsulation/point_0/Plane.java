package com.jimbarritt.encapsulation.point_0;

import static java.lang.Math.*;

public class Plane {

    /**
     * Uses pythagoras' equation to calculate the distance, h^2 = a^2 + b^2
     */
    public double distanceBetween(Point p1, Point p2) {
        int a = p2.x - p1.x;
        int b = p2.y - p1.y;
        return sqrt(pow(a, 2) + pow(b, 2));
    }

}