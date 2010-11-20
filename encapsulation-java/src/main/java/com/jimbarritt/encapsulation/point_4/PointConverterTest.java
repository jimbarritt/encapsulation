package com.jimbarritt.encapsulation.point_4;

import org.junit.*;

import static com.jimbarritt.encapsulation.point_4.CalculationPrecision.*;
import static java.lang.String.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
 */
public class PointConverterTest {

    private PointConverter pointConverter;

    @Before
    public void setup() {
        pointConverter = new PointConverter();
    }

    @Test
    public void converts_polar_to_polar() {
        PolarPoint polarPoint = new PolarPoint(0.9827937, 36.0555128);

        PolarPoint convertedPoint = pointConverter.toPolarPoint(polarPoint);

        assertThat(convertedPoint, is(polarPoint));
    }

    @Test
    public void converts_cartesian_to_polar_points() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        PolarPoint polarPoint = pointConverter.toPolarPoint(cartesianPoint);

        PolarPoint expectedPolarPoint = new PolarPoint(0.9827937, 36.0555128);
        assertThat(format("\nExpected: %s\nActual  : %s", expectedPolarPoint, polarPoint),
                polarPoint.isEqualTo(expectedPolarPoint, sixDecimalPlaces));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throws_if_unrecognised_point_type() {
        pointConverter.toPolarPoint(new Point() {

            public double distanceTo(Point other) {
                return 0;
            }

            public CartesianPoint asCartesianPoint() {
                return null;
            }
        });
    }


    @Test
    public void converts_cartesian_to_cartesian() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        CartesianPoint convertedPoint = pointConverter.toCartesianPoint(cartesianPoint);

        assertThat(convertedPoint, is(cartesianPoint));
    }

    /**
     * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
     */
    @Test
    public void converts_polar_to_cartesian() {
        PolarPoint polarPoint = new PolarPoint(0.9827937, 36.0555128);

        CartesianPoint convertedPoint = pointConverter.toCartesianPoint(polarPoint);

        CartesianPoint expectedPoint = new CartesianPoint(20, 30);
        assertThat(convertedPoint, is(expectedPoint));
    }
    
}