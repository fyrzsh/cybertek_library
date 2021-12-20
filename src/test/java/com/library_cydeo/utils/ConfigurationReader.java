package com.library_cydeo.utils;

import java.io.FileInputStream;
import java.util.Properties;


/*
     1) FileInputStream inputStream = new FileInputStream ("configuration.properties");

       2) private static Properties properties = new Properties();
          properties.load(inputStream);

       3)  public static String getProperty(String key) {
              return properties.getProperty(key);
           }
 */





/**
 * this util class is used to read values from configuration.properties file
 */
public class ConfigurationReader {
    private static Properties properties = new Properties();


    static  {

        try {
            //Open the file using inputstream
            FileInputStream inputStream = new FileInputStream ("configuration.properties");        //ctrl space -  to get variable/ object name suggestion from intelliJ

            //load to properties object
            properties.load(inputStream);


            //close the file after loading
            inputStream.close();

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Error occurred while reading configuration file");

        }
    }


    /**
     * Mthod is used to rread value from a configuration.properties file
     * @param key - key name is properties file
     * @return -> value forr the key. returns null if key not found
     * EX: driver.get( ConfigurationReader.getProperty("url");
     */

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
