package com.jimbarritt.encapsulation.point_5;

public class UnrecognisedPointTypeException extends IllegalArgumentException {

    public UnrecognisedPointTypeException(Point point) {
        super(String.format("I didn't recognise the type of point [%s]", point.getClass().getName()));
    }
}