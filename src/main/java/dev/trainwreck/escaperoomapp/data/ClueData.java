package dev.trainwreck.escaperoomapp.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClueData {
    private ObservableList<String> observableList = FXCollections.observableArrayList();

    public ClueData() {
    }

    public void setObservableList(ObservableList<String> observableList) {
        this.observableList = observableList;
    }

    public ObservableList<String> getObservableList() {
        return observableList;
    }

    public void saveClueData(String game){
        try {
            // write object to file
            Files.createDirectories(Paths.get("data/"+game));
            FileOutputStream fos = new FileOutputStream("data/"+game+"/ClueDataSaveFile.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<>(observableList));
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadClueData(String game){
        try {
            // write object to file
            FileInputStream fos = new FileInputStream("data/"+game+"/ClueDataSaveFile.ser");
            ObjectInputStream ois = new ObjectInputStream(fos);
            List<String> list = (List<String>) ois.readObject();
            observableList = FXCollections.observableList(list);
            ois.close();

        }catch (FileNotFoundException e){
            System.err.println("Clue File Not Found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
