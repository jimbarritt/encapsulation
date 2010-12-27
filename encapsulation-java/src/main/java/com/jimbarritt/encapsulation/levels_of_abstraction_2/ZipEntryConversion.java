package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import java.util.zip.*;

import static com.jimbarritt.encapsulation.levels_of_abstraction_2.Filename.*;

public class ZipEntryConversion {
    private final String entryPath;
    private final boolean hasNoSlash;
    private int indexOfLastSlash;

    public static ZipEntryConversion convert(ZipEntry zipEntry) {
        String name = zipEntry.getName();
        int indexOfLastSlash = name.lastIndexOf("/");
        boolean hasSlash =  indexOfLastSlash == -1;
        return new ZipEntryConversion(name, hasSlash, indexOfLastSlash);
    }

    private ZipEntryConversion(String entryPath, boolean hasNoSlash, int indexOfLastSlash) {
        this.entryPath = entryPath;
        this.hasNoSlash = hasNoSlash;
        this.indexOfLastSlash = indexOfLastSlash;
    }

    public ZipContentsEntry toZipContentsEntry() {
        Filename filename = filename();
        return new ZipContentsEntry(filename.getFullname(),
                filename.getType(),
                directory());
    }

    private Filename filename() {
        String name = this.hasNoSlash
                ? entryPath
                : entryPath.substring(indexOfLastSlash);

        return parse(trimLeadingSlash(name));
    }


    private String directory() {
        return this.hasNoSlash
                ? "/"
                : entryPath.substring(0, indexOfLastSlash);
    }

    private static String trimLeadingSlash(String name) {
        if (name.startsWith("/")) {
            return name.substring(1);
        }
        return name;
    }
}