package dev.trainwreck.escaperoomapp.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dev.trainwreck.escaperoomapp.data.gameobjects.GameData;
import dev.trainwreck.escaperoomapp.data.gameobjects.RoomData;
import dev.trainwreck.escaperoomapp.data.gameobjects.StepData;

import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

public class FileHelper {

    public static void CreateGameDataDir(List<GameData> gamesData){
        JsonObject gamesDataset = new JsonObject();;
        for (GameData game : gamesData) {
            gamesDataset.add(game.getGameName(),gameDataBuilder(game));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer writer = new FileWriter("data/GamesDir.json");
            gson.toJson(gamesDataset, writer);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public static JsonObject gameDataBuilder(GameData game){
        JsonObject gameDataset = new JsonObject();;
        gameDataset.addProperty("Name",game.getGameName());
        gameDataset.addProperty("UUID",game.getGameId().toString());

        int i = 0;
        for (RoomData roomdata : game.getRoomData()) {
            int j = 0;
            JsonObject roomDataset = new JsonObject();

            roomDataset.addProperty("Index",i);
            roomDataset.addProperty("UUID",roomdata.getRoomId().toString());
            for (StepData stepData: roomdata.getStepData()) {
                JsonObject stepDataset = new JsonObject();
                stepDataset.addProperty("Index",j);
                stepDataset.addProperty("UUID", roomdata.getRoomId().toString());
                roomDataset.add(stepData.getStepName(),stepDataset);
                j++;
            }
            gameDataset.add(roomdata.getRoomName(),roomDataset);
            i++;
        }

        return gameDataset;
    }

}
