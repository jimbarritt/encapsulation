package com.jimbarritt.encapsulation.point_6;

public class Line {

    private Point startPoint;
    private Point[] subsequentPoints;

    public Line(Point startPoint, Point... subsequentPoints) {
        this.startPoint = startPoint;
        this.subsequentPoints = subsequentPoints;
    }

    public int length() {        
        int totalLength = 0;

        Point currentPoint = startPoint;
        for (int i = 0; i < subsequentPoints.length; ++i) {
            totalLength += currentPoint.distanceTo(subsequentPoints[i]);
            currentPoint = subsequentPoints[i];
        }
        return totalLength;
    }
}