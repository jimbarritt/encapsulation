package com.jimbarritt.encapsulation.levels_of_abstraction_1;

import java.io.*;
import java.util.*;

import static java.lang.String.*;

public class ZipList {
    private File sourceFile;

    public static void main(String[] args) {
        try {
            ZipList zipList = new ZipList(new File(args[0]));
            zipList.run();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ZipList(File sourceFile) {
        this.sourceFile = sourceFile;
    }

    public void run() throws IOException {
        checkThatSourceFileExists();

        ZipContents zipContents = new ZipContents(sourceFile);

        try {
            zipContents.open();

            printListOfEntries(zipContents.entries());
        }finally {
            zipContents.close();
        }

    }

    private void checkThatSourceFileExists() throws FileNotFoundException {
        if (!sourceFile.exists()) {
            throw new FileNotFoundException(sourceFile.getAbsolutePath());
        }
    }

    private void printListOfEntries(List<ZipContentsEntry> contentsEntryList) {
        final String rowFormat = "%-15s %-20s %-5s";
        System.out.println(format(rowFormat, "Directory", "Name", "Type"));
        List<ZipContentsEntry> entries = contentsEntryList;
        for (ZipContentsEntry entry : entries) {
            System.out.println(format(rowFormat, entry.directory(), entry.name(), entry.type()));
        }
    }

}