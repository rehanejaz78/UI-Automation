package utils;

import java.io.*;
import java.util.*;
public class Utils {

    public static String getElementFromPropertiesFile(String key, String filename){
        Properties property = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/main/resources/" + filename + ".properties");
            property.load(file);
        } catch (IOException exception) {
            System.out.println("Something gone wrong in Utils. getElementFromPropertiesFile " + exception.getMessage());
        }
        return property.getProperty(key);
    }

    public static String getRandomString(int length) {
        String randomString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = (int)(randomString.length() * Math.random());
            sb.append(randomString.charAt(index));
        }
        return sb.toString();
    }
    public static int getRandomNumber ( int lowerBoundary, int upperBoundary) {

        //Generate random int value from lowerBoundary (e.g. 50 ) to upperBoundary (e.g. 100)
        int random_int = (int)Math.floor(Math.random()*(upperBoundary-lowerBoundary+1)+lowerBoundary);
        return random_int;
    }

    public static Boolean getRandomBoolean(){
        Random rd = new Random(); // creating Random object
        return rd.nextBoolean(); // displaying a random boolean
    }
}
