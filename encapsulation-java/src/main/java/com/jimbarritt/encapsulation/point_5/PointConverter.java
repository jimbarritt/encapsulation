package com.jimbarritt.encapsulation.point_5;

public class PointConverter {
    private final ToCartesianPointVisitor toCartesianPointVisitor = new ToCartesianPointVisitor();
    private final ToPolarPointVisitor toPolarPointVisitor = new ToPolarPointVisitor();

    public PolarPoint toPolarPoint(Point point) {
        point.accept(toPolarPointVisitor);
        return toPolarPointVisitor.convertedPoint();        
    }

    public CartesianPoint toCartesianPoint(Point point) {
        point.accept(toCartesianPointVisitor);
        return toCartesianPointVisitor.convertedPoint();
    }    

    private static class ToPolarPointVisitor extends PointVisitor {
        PolarPoint convertedPoint;

        @Override public void visit(CartesianPoint cartesianPoint) {
            convertedPoint = cartesianPoint.asPolarPoint();
        }

        @Override public void visit(PolarPoint polarPoint) {
            convertedPoint = polarPoint;
        }

        public PolarPoint convertedPoint() {
            return convertedPoint;
        }
    }

    private static class ToCartesianPointVisitor extends PointVisitor {
        CartesianPoint convertedPoint;

        @Override public void visit(CartesianPoint cartesianPoint) {
            convertedPoint = cartesianPoint;
        }

        @Override public void visit(PolarPoint polarPoint) {
            convertedPoint = polarPoint.asCartesianPoint();
        }

        public CartesianPoint convertedPoint() {
            return convertedPoint;
        }

    }
}