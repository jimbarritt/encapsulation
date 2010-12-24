package com.jimbarritt.encapsulation.point_6;

public class Line {

    private Point startPoint;
    private Point[] points;

    public Line(Point startPoint, Point... subsequentPoints) {
        this.startPoint = startPoint;
        this.points = subsequentPoints;
    }

    public int length() {        
        int totalLength = 0;

        Point currentPoint = startPoint;
        for (int i = 0; i < points.length; ++i) {
            totalLength += currentPoint.distanceTo(points[i]);
            currentPoint = points[i];
        }
        return totalLength;
    }
}