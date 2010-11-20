package com.jimbarritt.encapsulation.point_4;

public class PointConverter {

    public PolarPoint toPolar(Point point) {
        if (point instanceof PolarPoint) {
            return (PolarPoint)point;
        }

        if (point instanceof CartesianPoint) {
            return toPolar((CartesianPoint)point);
        }
        return null;
    }

    private PolarPoint toPolar(CartesianPoint cartesianPoint) {
        return cartesianPoint.asPolarPoint();      
    }
}