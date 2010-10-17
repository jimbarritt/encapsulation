package com.jimbarritt.encapsulation.level_0;

import org.junit.*;

import static java.lang.Math.abs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NoEncapsulationTest {

    @Test
    public void canDetermineFightingStrength() {
        Galleon galleon = new Galleon();

        galleon.totalPointsOfRedCrewCards = 3;
        galleon.totalPointsOfBlackCrewCards = 4;

        int fightingStrength = abs(galleon.totalPointsOfBlackCrewCards - galleon.totalPointsOfRedCrewCards);
        assertThat(fightingStrength, is(1));

    }
}