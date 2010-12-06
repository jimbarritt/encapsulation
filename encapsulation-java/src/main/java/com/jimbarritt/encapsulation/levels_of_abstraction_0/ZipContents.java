package com.jimbarritt.encapsulation.levels_of_abstraction_0;

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
        entries = new ArrayList<ZipContentsEntry>();

        zipfile = new ZipFile(sourceFile);

        Enumeration entries1 = zipfile.entries();
        while (entries1.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries1.nextElement();
            if (!entry.isDirectory()) {
                String entryPath = entry.getName();
                int index = entryPath.lastIndexOf("/");

                // Extract the filename
                String filename = (index == -1) ? entryPath : entryPath.substring(index);

                // Trim off any leading slashes
                int startIndex = (index == -1) ? 0 : 1;
                filename = filename.substring(startIndex, filename.length());

                // Extract file type
                int indexOfDot = filename.lastIndexOf(".");
                String type = filename.substring(indexOfDot + 1);

                // Extract the directory
                String directory = (index == -1) ? "/" : "/" + entryPath.substring(0, index);

                ZipContentsEntry contentEntry = new ZipContentsEntry(filename, type, directory);
                this.entries.add(contentEntry);
            }
        }
    }

    public List<ZipContentsEntry> entries() {
        return entries;
    }    

    public void close() throws IOException {
        if (zipfile != null) {
            zipfile.close();
        }
    }

}