/*
 * This code is the property of John Dixon.
 * Unless given my explicit permission, nobody may copy or redistribute this code.
 */
package com.mycompany.htmlsorter.utils;

/**
 *
 * @author john
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadConfig {

    private Properties prop;
    private OutputStream output;
    private InputStream input;

    public ReadConfig() throws IOException {

    }

    public void setProperty(String property, String toBeSetAs) {
        prop = new Properties();
        output = null;

        try {

            output = new FileOutputStream("config.properties");

            // set the properties value
            prop.setProperty(property, toBeSetAs);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public boolean arePropertiesSet() {
        prop = new Properties();
        input = null;
        boolean arePropsSet = false;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            String HTMLValue = prop.getProperty("html");
            String description = prop.getProperty("description");
            String finishedfile = prop.getProperty("finishedfile");
            arePropsSet = !(HTMLValue.equals("") || description.equals("") || finishedfile.equals(""));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return arePropsSet;
    }
}
