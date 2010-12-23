package com.jimbarritt.encapsulation.point_6;

import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class LineTest {


    @Test
    public void can_calculate_the_length_of_a_line() {
        Point point1 = pointWithDistanceToNextPointOf(3);
        Point point2 = pointWithDistanceToNextPointOf(4);
        Point point3 = pointWithDistanceToNextPointOf(1);
        Point point4 = pointWithDistanceToNextPointOf(2);


        Line line = new Line(point1, point2, point3, point4);

        assertThat(line.length(), is(10));

    }

    private static Point pointWithDistanceToNextPointOf(int distanceToNextPoint) {
        return new FakePoint(distanceToNextPoint);
    }

    private static class FakePoint implements Point {
        private int distanceToNextPoint;

        private FakePoint(int distanceToNextPoint) {
            this.distanceToNextPoint = distanceToNextPoint;
        }


        public double distanceTo(Point other) {
            return distanceToNextPoint;
        }

        public PointConversion accept(PointConversion pointConversion) {
            return null;
        }
    }
}