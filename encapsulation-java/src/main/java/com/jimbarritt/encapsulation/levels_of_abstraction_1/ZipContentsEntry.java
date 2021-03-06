package com.jimbarritt.encapsulation.levels_of_abstraction_1;

public class ZipContentsEntry {

    private final String name;
    private final String type;
    private final String directory;

    public ZipContentsEntry(String name, String type, String directory) {
        this.name = name;
        this.type = type;
        this.directory = directory;
    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    public String directory() {
        return directory;
    }

}