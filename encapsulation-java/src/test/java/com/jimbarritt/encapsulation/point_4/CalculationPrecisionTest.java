package com.jimbarritt.encapsulation.point_4;

import org.junit.*;

import static com.jimbarritt.encapsulation.point_4.CalculationPrecision.*;
import static java.lang.String.format;
import static junit.framework.Assert.*;

public class CalculationPrecisionTest {

    @Test
    public void five_decimal_places() {
        double[] a = new double[] {0.123456, 0.123452};
        double[] b = new double[] {0.123457, 0.123459};

        for (int i = 0; i < a.length; ++i) {
            boolean areEqual = fiveDecimalPlaces.isEqual(a[i], b[i]);

            assertTrue(format("%.6f should equal %.6f at 5 d.p", a[i], b[i]), areEqual);
        }
    }

    @Test
    public void six_decimal_places() {
        double[] a = new double[] {0.1234567, 0.1234569, 0.1234565};
        double[] b = new double[] {0.1234565, 0.1234561, 0.1234565};

        for (int i = 0; i < a.length; ++i) {
            boolean areEqual = fiveDecimalPlaces.isEqual(a[i], b[i]);

            assertTrue(format("%.6f should equal %.6f at 6 d.p", a[i], b[i]), areEqual);
        }
    }
}