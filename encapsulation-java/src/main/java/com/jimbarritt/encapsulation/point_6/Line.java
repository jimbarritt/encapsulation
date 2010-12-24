package com.jimbarritt.encapsulation.point_6;

public class Line {

    private Point[] points;

    public Line(Point... points) {
        this.points = points;
    }

    public int length() {
        int totalLength = 0;

        Point startPoint = points[0];
        for (int i = 1; i < points.length; ++i) {
            totalLength += startPoint.distanceTo(points[i]);
            startPoint = points[i];
        }
        return totalLength;
    }
}