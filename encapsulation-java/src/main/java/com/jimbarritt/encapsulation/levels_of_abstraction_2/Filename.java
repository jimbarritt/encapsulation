package com.jimbarritt.encapsulation.levels_of_abstraction_2;

public class Filename {

    private String fullname;
    private String type;

    public static Filename parse(String filenameString) {
        String fileType = filenameString.substring(filenameString.lastIndexOf(".") + 1);
        return new Filename(filenameString, fileType);
    }

    private Filename(String filenameString, String type) {
        this.fullname = filenameString;
        this.type = type;
    }

    public String getFullname() {
        return fullname;
    }

    public String getType() {
        return type;
    }
}