package com.jimbarritt.encapsulation.levels_of_abstraction_1;

import org.apache.log4j.*;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipContents {
    private static final Logger log = Logger.getLogger(ZipContents.class);

    private final File sourceFile;

    private ZipFile zipfile;
    private List<ZipContentsEntry> entries = new ArrayList<ZipContentsEntry>();


    public ZipContents(File sourceFile) {
        this.sourceFile = sourceFile;
    }


    public List<ZipContentsEntry> entries() {
        return entries;
    }

    public void open() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Opening file: " + sourceFile.getAbsolutePath());
        }
        listEntries();
    }

    public void close() throws IOException {
        if (log.isInfoEnabled()) {
            log.info("Closing File: " + sourceFile.getAbsolutePath());
        }
        if (zipfile != null) {
            zipfile.close();
        }
    }

    private void listEntries() throws IOException {
        entries = new ArrayList<ZipContentsEntry>();
        zipfile = new ZipFile(sourceFile);

        Enumeration entries = zipfile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (!entry.isDirectory()) {
                addEntry(entry);
            }
        }
    }

    private void addEntry(ZipEntry entry) {
        String entryPath = entry.getName();
        int indexOfLastSlash = entryPath.lastIndexOf("/");

        String name = (indexOfLastSlash == -1) ? entryPath : entryPath.substring(indexOfLastSlash);

        int indexDot = name.lastIndexOf(".");

        String type = name.substring(indexDot + 1);
        int startIndex = (indexOfLastSlash == -1) ? 0 : 1;
        name = name.substring(startIndex, name.length());

        String directory = (indexOfLastSlash == -1) ? "/" : "/" + entryPath.substring(0, indexOfLastSlash);

        ZipContentsEntry contentEntry = new ZipContentsEntry(name, type, directory);
        this.entries.add(contentEntry);
    }

}