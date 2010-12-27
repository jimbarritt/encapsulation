package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import org.junit.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class FilenameTest {



    @Test
    public void determines_fullname() {
        Filename filename = Filename.parse("somefile.txt");

        assertThat(filename.getFullname(), is("somefile.txt"));
    }

    @Test
    public void determines_type() {
        Filename filename = Filename.parse("somefile.txt");

        assertThat(filename.getType(), is("txt"));
    }
}