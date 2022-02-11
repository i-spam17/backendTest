package com.gb.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Helpers {
    public static String getResourceAsString(String path) throws IOException {
        return new String(FileUtils.readFileToByteArray(new File(path)));
    }

    public static int currentDataToInt(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = java.sql.Date.valueOf(str);

        return (int) (date.getTime() / 1000);
    }

    public static void main(String[] args) {
        String date = "2022-03-02";
        System.out.println("Date : " + currentDataToInt(date) +
                "\nCheck Date : " + new Date(((long) currentDataToInt(date)) * 1000L));
    }
}
