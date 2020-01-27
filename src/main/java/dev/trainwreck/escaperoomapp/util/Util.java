package dev.trainwreck.escaperoomapp.util;

import java.net.URL;

public class Util {
    public static URL resource(String path){
        return Util.class.getClassLoader().getResource(path);
    }
}
