package com.jimbarritt.encapsulation.point_6;

/**
 * This is a visitor pattern for converting the points so we don't need to cast
 */
public abstract class PointConversion<T extends Point> {
    private T convertedPoint;

    public abstract void convert(CartesianPoint cartesianPoint);
    public abstract void convert(PolarPoint polarPoint);

    @SuppressWarnings("unchecked")
    public static <T extends Point> T convertPoint(Point point, PointConversion<T> conversion) {
        return (T)point.accept(conversion).convertedPoint();
    }

    public T convertedPoint() {
        return convertedPoint;
    }

    public void recordResultOfConversion(T convertedPoint) {
        this.convertedPoint = convertedPoint;
    }
}
