package com.jimbarritt.encapsulation.point_6;

public interface Point {
    double distanceTo(Point other);
    PointConversion accept(PointConversion pointConversion);
}