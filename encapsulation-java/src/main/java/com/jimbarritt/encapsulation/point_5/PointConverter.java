package com.jimbarritt.encapsulation.point_5;

public class PointConverter {

    public PolarPoint toPolarPoint(Point point) {
        ToPolarPointVisitor toPolarPointVisitor = new ToPolarPointVisitor();
        point.accept(toPolarPointVisitor);
        return toPolarPointVisitor.convertedPoint();        
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


    private class ToPolarPointVisitor extends PointVisitor {
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
}