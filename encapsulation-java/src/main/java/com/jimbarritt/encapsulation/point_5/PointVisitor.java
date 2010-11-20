package com.jimbarritt.encapsulation.point_5;

public abstract class PointVisitor {
    public void visit(CartesianPoint cartesianPoint) {}
    public void visit(PolarPoint polarPoint) {};
}