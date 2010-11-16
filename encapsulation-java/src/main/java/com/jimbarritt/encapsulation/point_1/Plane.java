package com.jimbarritt.encapsulation.point_1;

import static java.lang.Math.*;

public class Plane {

    /**
     * Uses pythagoras to calculate the distance, h^2 = a^2 + b^2
     */
    public double distanceBetween(Point p1, Point p2) {
        int a = p2.getX() - p1.getX();
        int b = p2.getY() - p1.getY();
        return sqrt(pow(a, 2) + pow(b, 2));
    }

}