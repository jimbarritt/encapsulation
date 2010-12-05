package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import org.junit.*;

import java.util.zip.*;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ZipEntryConversionTest {

    @Before
    public void setUp() {

    }

    @Test
    public void converts_full_path_to_zip_contents_entry() {
        ZipEntry zipEntry = new ZipEntry("some/path/to/a/file.txt");
        ZipEntryConversion zipEntryConversion = new ZipEntryConversion(zipEntry);

        ZipContentsEntry zipContentsEntry = zipEntryConversion.toZipContentsEntry();

        assertThat(zipContentsEntry.directory(), is("some/path/to/a"));
        assertThat(zipContentsEntry.name(), is("file.txt"));
        assertThat(zipContentsEntry.type(), is("txt"));
    }

    @Test
    public void converts_root_path_to_zip_contents_entry() {
        ZipEntry zipEntry = new ZipEntry("/");
        ZipEntryConversion zipEntryConversion = new ZipEntryConversion(zipEntry);

        ZipContentsEntry zipContentsEntry = zipEntryConversion.toZipContentsEntry();

        assertThat(zipContentsEntry.directory(), is(""));
        assertThat(zipContentsEntry.name(), is(""));
        assertThat(zipContentsEntry.type(), is(""));
    }

}