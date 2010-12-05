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
                entries.add(createEntryFrom(zipEntry));
            }
        }
    }

    private static ZipContentsEntry createEntryFrom(ZipEntry entry) {
        String entryPath = entry.getName();

        String name = getFilenameFrom(entryPath);
        String type = getTypeFrom(name);
        String directory = getDirectoryFrom(entryPath);

        return new ZipContentsEntry(name, type, directory);
    }

    private static String getFilenameFrom(String entryPath) {
        int indexOfLastSlash = entryPath.lastIndexOf("/");
        String name = (indexOfLastSlash == -1) ? entryPath : entryPath.substring(indexOfLastSlash);
        int startIndex = (indexOfLastSlash == -1) ? 0 : 1;
        return name.substring(startIndex, name.length());
    }

    private static String getDirectoryFrom(String entryPath) {
        int indexOfLastSlash = entryPath.lastIndexOf("/");
        return (indexOfLastSlash == -1) ? "/" : "/" + entryPath.substring(0, indexOfLastSlash);
    }

    private static String getTypeFrom(String name) {
        int indexDot = name.lastIndexOf(".");
        return name.substring(indexDot + 1);
    }

}