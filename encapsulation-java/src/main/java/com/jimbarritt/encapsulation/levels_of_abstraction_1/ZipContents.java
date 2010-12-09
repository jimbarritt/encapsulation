package com.jimbarritt.encapsulation.levels_of_abstraction_1;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipContents {
    private final File sourceFile;

    private ZipFile zipfile;
    private List<ZipContentsEntry> entries = new ArrayList<ZipContentsEntry>();

    public ZipContents(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void open() throws IOException {
        readEntries();
    }

    public List<ZipContentsEntry> entries() {
        return entries;
    }

    public void close() throws IOException {
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

        String name = extractFilenameFrom(entryPath);
        String type = extractTypeFrom(name);
        String directory = extractDirectoryFrom(entryPath);

        return new ZipContentsEntry(name, type, directory);
    }

    private static String extractFilenameFrom(String entryPath) {
        int indexOfLastSlash = entryPath.lastIndexOf("/");
        String filename = (indexOfLastSlash == -1) ? entryPath : entryPath.substring(indexOfLastSlash);
        int startIndex = (indexOfLastSlash == -1) ? 0 : 1;
        return filename.substring(startIndex, filename.length());
    }

    private static String extractDirectoryFrom(String entryPath) {
        int indexOfLastSlash = entryPath.lastIndexOf("/");
        return (indexOfLastSlash == -1) ? "/" : "/" + entryPath.substring(0, indexOfLastSlash);
    }

    private static String extractTypeFrom(String filename) {
        int indexOfDot = filename.lastIndexOf(".");
        return filename.substring(indexOfDot + 1);
    }

}