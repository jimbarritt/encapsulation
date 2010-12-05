package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import org.junit.*;

import java.io.*;
import java.util.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ZipContentsIntegrationTest {


    @Test
    public void reads_a_list_of_entries() throws Exception {
        ZipContents zipContents = new ZipContents(new File("./src/test/resource/test.zip"));

        try {
            zipContents.open();

            List<ZipContentsEntry> entries = zipContents.entries();
            assertThat(entries.size(), is(6));

            ZipContentsEntry firstEntry = entries.get(0);
            assertThat(firstEntry.directory(), is("/"));
            assertThat(firstEntry.name(), is("file_1.txt"));
            assertThat(firstEntry.type(), is("txt"));
        } finally {
            zipContents.close();
        }

    }


}