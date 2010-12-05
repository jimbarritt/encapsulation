package com.jimbarritt.encapsulation.levels_of_abstraction_0;

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
        if (!sourceFile.exists()) {
            throw new FileNotFoundException(sourceFile.getAbsolutePath());
        }
        ZipContents zipContents = new ZipContents(sourceFile);
        final String rowFormat = "%-15s %-20s %-5s";

        try {
            zipContents.open();

            System.out.println(format(rowFormat, "Directory", "Name", "Type"));
            List<ZipContentsEntry> entries = zipContents.entries();
            for (ZipContentsEntry entry : entries) {
                System.out.println(format(rowFormat, entry.directory(), entry.name(), entry.type()));
            }

        }finally {
            zipContents.close();
        }

    }

}