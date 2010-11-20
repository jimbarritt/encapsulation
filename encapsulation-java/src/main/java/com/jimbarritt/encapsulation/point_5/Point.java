package com.jimbarritt.encapsulation.point_5;

public interface Point {
    double distanceTo(Point other);
    void accept(PointVisitor pointVisitor);
}