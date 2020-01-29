package dev.trainwreck.escaperoomapp.util;


import java.io.File;
import java.net.URL;


public class Util {
    public static URL resource(String path){
        return Util.class.getClassLoader().getResource(path);
    }

    public static String findUUIDString(String gameName){
        File folder = new File("data/"+gameName);
        for (final File fileEntry : folder.listFiles()) {
            if(fileEntry.getName().endsWith(".dat")){
                return fileEntry.getName();
            }
        }
        return null;
    }


}
