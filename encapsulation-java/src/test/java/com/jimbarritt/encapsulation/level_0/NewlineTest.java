package com.jimbarritt.encapsulation.level_0;

import org.junit.*;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NewlineTest {

    @Test
    public void what_is_the_file_separator() {

        String separator = System.getProperty("line.separator");

        assertThat(separator, is("\n"));

    }

    private static class Address {
        private String line1, postcode;

        public Address(String line1, String postcode) {
            this.line1 = line1;
            this.postcode = postcode;
        }

        public String getLine1() { return line1; }
        public String getPostcode() { return postcode; }

        public void setLine1(String line1) { this.line1 = line1; }
        public void setPostcode(String postcode) { this.postcode = postcode; }
        
    }

}