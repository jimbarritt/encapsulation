package com.jimbarritt.encapsulation.point_4;

import static java.lang.String.*;

public class PointConverter {

    public PolarPoint toPolarPoint(Point point) {
        if (point instanceof PolarPoint) {
            return (PolarPoint) point;
        }

        if (point instanceof CartesianPoint) {
            return toPolar((CartesianPoint) point);
        }
        throw new IllegalArgumentException(format("I didn't recognise the type of point [%s]", point.getClass().getName()));
    }

    public CartesianPoint toCartesianPoint(Point point) {
        if (point instanceof CartesianPoint) {
            return (CartesianPoint) point;
        }
        return null;
    }

    private PolarPoint toPolar(CartesianPoint cartesianPoint) {
        return cartesianPoint.asPolarPoint();
    }


}