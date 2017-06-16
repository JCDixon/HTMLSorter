/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.utils;

/**
 *
 * @author john
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {

    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String html = prop.getProperty("html");
            String description = prop.getProperty("description");
            String finishedfile = prop.getProperty("finishedfile");

            result = "Company List = " + html + ", " + description + ", " + finishedfile;
            System.out.println(result + "\nProgram Ran on " + time);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
