package dev.trainwreck.escaperoomapp.data.gameobjects;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomData {
    private UUID roomId;
    private String roomName;
    private List<StepData> stepData = new ArrayList<>();

    public RoomData(String roomName) {
        this.roomId = UUID.randomUUID();
        this.roomName = roomName;

        stepData.add(new StepData("john"));
        stepData.add(new StepData("doe"));
    }

    public RoomData(String roomName, List<StepData> stepData) {
        this.roomId = UUID.fromString(roomName);
        this.roomName = roomName;
        this.stepData = stepData;
    }

    public void saveRoomData(String gameName){
        try {
            // write object to file
            Files.createDirectories(Paths.get("data/"+gameName+"/rooms"));
            FileOutputStream fos = new FileOutputStream("data/"+gameName+"rooms/"+roomId.toString()+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(stepData);
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadRoomData(String gameName){
        try {
            // write object to file
            FileInputStream fos = new FileInputStream("data/"+gameName+"rooms/"+roomId.toString()+".ser");
            ObjectInputStream ois = new ObjectInputStream(fos);
            stepData = (List<StepData>) ois.readObject();
            ois.close();

        }catch (FileNotFoundException e){
            System.err.println("Room File Not Found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<StepData> getStepData() {
        return stepData;
    }

    public String getRoomName() {
        return roomName;
    }

    public UUID getRoomId() {
        return roomId;
    }
}
