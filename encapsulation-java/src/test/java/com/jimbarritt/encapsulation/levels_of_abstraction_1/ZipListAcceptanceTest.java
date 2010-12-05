package com.jimbarritt.encapsulation.levels_of_abstraction_1;

import com.jimbarritt.encapsulation.levels_of_abstraction_0.ZipList;
import org.junit.*;

public class ZipListAcceptanceTest {

    @Test                      
    public void displays_the_contents_of_a_zip_file() throws Exception {
        ZipList.main(new String[] {"./src/test/resource/test.zip"});
    }

    @Test
    public void fails_gracefully() throws Exception {
        ZipList.main(new String[]{"./src/test/resource/i_dont_exist.zip"});
    }

}