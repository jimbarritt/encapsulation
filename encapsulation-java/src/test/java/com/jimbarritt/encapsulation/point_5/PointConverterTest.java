package com.jimbarritt.encapsulation.point_5;

import org.junit.*;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

/**
 * p1 == {20, 30} == {theta=0.9827937, r=36.0555128}
 */
public class PointConverterTest {

    private PointConverter pointConverter;
    @Mock private PolarPoint polarPoint;
    @Mock private PointConversion pointConversion;
    @Mock private CartesianPoint cartesianPoint;

    @Before
    public void setup() {
        initMocks(this);
        pointConverter = new PointConverter();
    }

    @Test
    public void converts_polar_to_polar() {
        when(polarPoint.accept(isA(PointConversion.class))).thenReturn(pointConversion);
        when(pointConversion.convertedPoint()).thenReturn(polarPoint);

        PolarPoint convertedPoint = pointConverter.asPolarPoint(polarPoint);

        assertThat(convertedPoint, is(sameInstance(polarPoint)));
    }

    @Test
    public void converts_polar_to_cartesian() {
        when(polarPoint.accept(isA(PointConversion.class))).thenReturn(pointConversion);
        when(pointConversion.convertedPoint()).thenReturn(cartesianPoint);

        CartesianPoint convertedPoint = pointConverter.asCartesianPoint(polarPoint);

        assertThat(convertedPoint, is(sameInstance(cartesianPoint)));
    }

    @Test
    public void converts_cartesian_to_cartesian() {
        when(cartesianPoint.accept(isA(PointConversion.class))).thenReturn(pointConversion);
        when(pointConversion.convertedPoint()).thenReturn(cartesianPoint);

        CartesianPoint convertedPoint = pointConverter.asCartesianPoint(cartesianPoint);

        assertThat(convertedPoint, is(sameInstance(cartesianPoint)));
    }

    @Test
    public void converts_cartesian_to_polar_points() {
        when(cartesianPoint.accept(isA(PointConversion.class))).thenReturn(pointConversion);
        when(pointConversion.convertedPoint()).thenReturn(polarPoint);

        PolarPoint convertedPoint = pointConverter.asPolarPoint(cartesianPoint);

        assertThat(convertedPoint, is(sameInstance(polarPoint)));
    }

}