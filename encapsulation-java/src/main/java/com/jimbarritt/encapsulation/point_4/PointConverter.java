package com.jimbarritt.encapsulation.point_4;

public class PointConverter {

    public PolarPoint toPolarPoint(Point point) {
        if (point instanceof PolarPoint) {
            return (PolarPoint) point;
        }

        if (point instanceof CartesianPoint) {
            return toPolar((CartesianPoint) point);
        }
        throw new UnrecognisedPointTypeException(point);
    }

    public CartesianPoint toCartesianPoint(Point point) {
        if (point instanceof CartesianPoint) {
            return (CartesianPoint) point;
        }

        if (point instanceof PolarPoint) {
            return toCartesian((PolarPoint)point);
        }
        throw new UnrecognisedPointTypeException(point);
    }

    private CartesianPoint toCartesian(PolarPoint polarPoint) {
        return polarPoint.asCartesianPoint();
    }

    private PolarPoint toPolar(CartesianPoint cartesianPoint) {
        return cartesianPoint.asPolarPoint();
    }


}