package com.jimbarritt.encapsulation.point_5;

import static java.lang.Math.*;

public enum CalculationPrecision {

    fiveDecimalPlaces(0.00001),
    sixDecimalPlaces (0.000001);
    
    private final long delta;

    private CalculationPrecision(double delta) {
        this.delta = round(1 / delta);        
    }

    public boolean isEqual(double a, double b) {
        return (int)(abs(a - b) * delta) <= 1;
    }
}