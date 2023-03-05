package com.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            // creating a FileInputStream object and passing configuration properties file as path to its constructor
            FileInputStream file = new FileInputStream("configuration.properties");
            // loading the file to properties object
            properties.load(file);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * This method accepts configuration.properties key as a string and return it
     *
     * @param keyword configuration properties key
     * @return configuration properties value
     */
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }

}
