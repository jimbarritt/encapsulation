package com.jimbarritt.encapsulation.point_4;

public interface Point {
    double distanceTo(Point other);

    CartesianPoint asCartesianPoint();
}