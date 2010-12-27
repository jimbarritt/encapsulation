package com.jimbarritt.encapsulation.levels_of_abstraction_2;

import java.util.zip.*;

public class ZipEntryConversion {
    private final ZipEntry zipEntry;
    private final String entryPath;

    public static ZipEntryConversion convert(ZipEntry zipEntry) {
        return new ZipEntryConversion(zipEntry);
    }

    public ZipEntryConversion(ZipEntry zipEntry) {
        this.zipEntry = zipEntry;
        this.entryPath = zipEntry.getName();
    }

    public ZipContentsEntry toZipContentsEntry() {
        Filename filename = filename();
        return new ZipContentsEntry(filename.getFullname(),
                filename.getType(),
                directory());
    }

    private Filename filename() {
        String name = pathHasNoSlash()
                ? entryPath
                : entryPath.substring(indexOfLastSlash());

        return Filename.parse(trimLeadingSlash(name));
    }


    private String directory() {
        return pathHasNoSlash()
                ? "/"
                : entryPath.substring(0, indexOfLastSlash());
    }

    private boolean pathHasNoSlash() {
        return indexOfLastSlash() == -1;
    }

    private int indexOfLastSlash() {
        return zipEntry.getName().lastIndexOf("/");
    }

    private String trimLeadingSlash(String name) {
        if (name.startsWith("/")) {
            return name.substring(1);
        }
        return name;
    }
}