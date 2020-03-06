package dev.trainwreck.escaperoomapp.util;


import com.google.gson.Gson;
import dev.trainwreck.escaperoomapp.data.gameobjects.GameData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Util {
    public static URL resource(String path){
        return Util.class.getClassLoader().getResource(path);
    }

    public static List<GameData> loadGameData(){
        List<GameData> gamesData = new ArrayList<>();
        Gson gson = new Gson();

        try{
         File file = new File("data/GamesDir.json");
         if(file.exists()){
             BufferedReader br = new BufferedReader(new FileReader(file));
             Map<?, ?> map = gson.fromJson(br, Map.class);

             // print map entries
             for (Map.Entry<?, ?> entry : map.entrySet()) {
                 System.out.println(entry.getKey() + "=" + entry.getValue());
                 System.out.println(entry.getKey());

                 gamesData.add(new GameData(entry.getKey().toString()));
             }
         }else {

         }

     }catch (Exception e){
         e.printStackTrace();
     }
     return gamesData;
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
