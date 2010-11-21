package com.jimbarritt.encapsulation.point_5;

import static com.jimbarritt.encapsulation.point_5.PointConversion.*;

public class PointConverter {
    private final ToCartesianPointConversion toCartesianPoint = new ToCartesianPointConversion();
    private final ToPolarPointConversion toPolarPoint = new ToPolarPointConversion();

    public PolarPoint asPolarPoint(Point point) {
        return convertPoint(point, toPolarPoint);
    }

    public CartesianPoint asCartesianPoint(Point point) {
        return convertPoint(point, toCartesianPoint);
    }
    
    private static class ToPolarPointConversion extends PointConversion<PolarPoint> {
        @Override public void convert(CartesianPoint cartesianPoint) {
            super.recordResultOfConversion(cartesianPoint.asPolarPoint());
        }

        @Override public void convert(PolarPoint polarPoint) {
            super.recordResultOfConversion(polarPoint);
        }
    }

    private static class ToCartesianPointConversion extends PointConversion<CartesianPoint> {
        @Override public void convert(CartesianPoint cartesianPoint) {
            super.recordResultOfConversion(cartesianPoint);
        }

        @Override public void convert(PolarPoint polarPoint) {
            super.recordResultOfConversion(polarPoint.asCartesianPoint());
        }
    }
}