package com.jimbarritt.encapsulation.point_4;

import static java.lang.String.*;

public class Radians {

    private final double doubleValue;

    public static Radians radians(double value) {
        return new Radians(value);
    }

    public Radians(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public double doubleValue() {
        return doubleValue;
    }

    public boolean isEqual(Radians other, CalculationPrecision precision) {
        return precision.isEqual(doubleValue, other.doubleValue());
    }

    public double cos() {
        return Math.cos(doubleValue);
    }

    public double sin() {
        return Math.sin(doubleValue);
    }

    public String toString() {
        return format("%.7f", doubleValue);
    }
}