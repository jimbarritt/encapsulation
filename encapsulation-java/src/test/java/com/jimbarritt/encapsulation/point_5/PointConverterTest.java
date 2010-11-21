package com.jimbarritt.encapsulation.point_5;

import org.junit.*;

import static com.jimbarritt.encapsulation.point_5.CalculationPrecision.*;
import static java.lang.String.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;

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

        PolarPoint convertedPoint = pointConverter.asPolarPoint(polarPoint);

        assertThat(convertedPoint, is(polarPoint));
    }

    @Test
    public void converts_polar_to_polar_mocked() {
        PolarPoint polarPoint = mock(PolarPoint.class);
        PointConversion pointConversion = mock(PointConversion.class);

        when(polarPoint.accept(isA(PointConversion.class))).thenReturn(pointConversion);
        when(pointConversion.convertedPoint()).thenReturn(polarPoint);

        PolarPoint convertedPoint = pointConverter.asPolarPoint(polarPoint);

        assertThat(convertedPoint, is(polarPoint));
    }

    /**
     * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
     */
    @Test
    public void converts_polar_to_cartesian() {
        PolarPoint polarPoint = new PolarPoint(0.9827937, 36.0555128);

        CartesianPoint convertedPoint = pointConverter.asCartesianPoint(polarPoint);

        CartesianPoint expectedPoint = new CartesianPoint(20, 30);
        assertThat(convertedPoint, is(expectedPoint));
    }


    @Test
    public void converts_cartesian_to_cartesian() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        CartesianPoint convertedPoint = pointConverter.asCartesianPoint(cartesianPoint);

        assertThat(convertedPoint, is(cartesianPoint));
    }

    @Test
    public void converts_cartesian_to_polar_points() {
        CartesianPoint cartesianPoint = new CartesianPoint(20, 30);

        PolarPoint polarPoint = pointConverter.asPolarPoint(cartesianPoint);

        PolarPoint expectedPolarPoint = new PolarPoint(0.9827937, 36.0555128);
        assertThat(format("\nExpected: %s\nActual  : %s", expectedPolarPoint, polarPoint),
                polarPoint.isEqualTo(expectedPolarPoint, sixDecimalPlaces));
    }

}