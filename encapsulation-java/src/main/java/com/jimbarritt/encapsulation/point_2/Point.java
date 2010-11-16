package com.jimbarritt.encapsulation.point_2;

public interface Point {
    double distanceTo(Point other);

    CartesianPoint asCartesianPoint();
}