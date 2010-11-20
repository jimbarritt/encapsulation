package com.jimbarritt.encapsulation.point_5;

import org.junit.*;

import static junit.framework.Assert.*;

public class PolarPointTest {

    @Test
    public void converts_to_cartesian() {
        PolarPoint p1 = new PolarPoint(0.9827937, 36.0555128);

        CartesianPoint p2 = p1.asCartesianPoint();

        assertEquals(p2.toString(), "x=20, y=30");
    }
}