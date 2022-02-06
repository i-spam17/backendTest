package com.gb.backend;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;


public class Helpers {
    public static String getResourceAsString (String path) throws IOException {
        return new String(FileUtils.readFileToByteArray(new File(path)));
    }
}
