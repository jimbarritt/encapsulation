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
        return new ZipContentsEntry(getFilename(),
                                    getType(),
                                    getDirectory());
    }

    private String getFilename() {
        String name = pathHasNoSlash()
                            ? entryPath
                            : entryPath.substring(indexOfLastSlash());

        return trimLeadingSlash(name);
    }

    private String getDirectory() {
        return pathHasNoSlash()
                      ? "/"
                      : entryPath.substring(0, indexOfLastSlash());
    }

    private String getType() {
        String filename = getFilename();
        int indexDot = filename.lastIndexOf(".");
        return filename.substring(indexDot + 1);
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