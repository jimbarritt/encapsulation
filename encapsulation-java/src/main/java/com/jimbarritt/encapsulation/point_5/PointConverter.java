package com.jimbarritt.encapsulation.point_5;

public class PointConverter {
    private final ToCartesianPointVisitor toCartesianPointVisitor = new ToCartesianPointVisitor();
    private final ToPolarPointVisitor toPolarPointVisitor = new ToPolarPointVisitor();

    public PolarPoint asPolarPoint(Point point) {
        point.accept(toPolarPointVisitor);
        return toPolarPointVisitor.convertedPoint();        
    }

    public CartesianPoint asCartesianPoint(Point point) {
        point.accept(toCartesianPointVisitor);
        return toCartesianPointVisitor.convertedPoint();
    }

    private static abstract class AbstractPointConversion<T> extends PointVisitor {
        private T convertedPoint;

        public void recordResultOfConversion(T convertedPoint) {
            this.convertedPoint = convertedPoint;
        }

        public T convertedPoint() {
            return convertedPoint;
        }
    }

    private static class ToPolarPointVisitor extends AbstractPointConversion<PolarPoint> {
        @Override public void visit(CartesianPoint cartesianPoint) {
            super.recordResultOfConversion(cartesianPoint.asPolarPoint());
        }

        @Override public void visit(PolarPoint polarPoint) {
            super.recordResultOfConversion(polarPoint);
        }
    }

    private static class ToCartesianPointVisitor extends AbstractPointConversion<CartesianPoint> {
        @Override public void visit(CartesianPoint cartesianPoint) {
            super.recordResultOfConversion(cartesianPoint);
        }

        @Override public void visit(PolarPoint polarPoint) {
            super.recordResultOfConversion(polarPoint.asCartesianPoint());
        }
    }
}