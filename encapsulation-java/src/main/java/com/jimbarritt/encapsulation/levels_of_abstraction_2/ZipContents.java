package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import org.apache.log4j.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;

import static com.jimbarritt.encapsulation.levels_of_abstraction_2.ZipEntryConversion.*;

public class ZipContents {
    private static final Logger log = Logger.getLogger(ZipContents.class);

    private final File sourceFile;

    private ZipFile zipfile;
    private List<ZipContentsEntry> entries = new ArrayList<ZipContentsEntry>();


    public ZipContents(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void open() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Opening file: " + sourceFile.getAbsolutePath());
        }
        readEntries();
    }

    public List<ZipContentsEntry> entries() {
        return entries;
    }

    public void close() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Closing File: " + sourceFile.getAbsolutePath());
        }
        if (zipfile != null) {
            zipfile.close();
        }
    }

    private void readEntries() throws IOException {
        entries = new ArrayList<ZipContentsEntry>();
        zipfile = new ZipFile(sourceFile);

        Enumeration zipFileEntries = zipfile.entries();
        while (zipFileEntries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) zipFileEntries.nextElement();
            if (!zipEntry.isDirectory()) {
                entries.add(convert(zipEntry).toZipContentsEntry());
            }
        }
    }

}