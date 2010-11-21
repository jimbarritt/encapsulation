package com.jimbarritt.encapsulation.point_5;

public class PointConverter {
    private final ToCartesianPointConversion toCartesianPointVisitor = new ToCartesianPointConversion();
    private final ToPolarPointConversion toPolarPointVisitor = new ToPolarPointConversion();

    public PolarPoint asPolarPoint(Point point) {
        point.accept(toPolarPointVisitor);
        return toPolarPointVisitor.convertedPoint();        
    }

    public CartesianPoint asCartesianPoint(Point point) {
        point.accept(toCartesianPointVisitor);
        return toCartesianPointVisitor.convertedPoint();
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