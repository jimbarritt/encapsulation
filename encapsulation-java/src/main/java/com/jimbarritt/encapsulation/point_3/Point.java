package com.jimbarritt.encapsulation.point_3;

public interface Point {
    double distanceTo(Point other);

    CartesianPoint asCartesianPoint();
}