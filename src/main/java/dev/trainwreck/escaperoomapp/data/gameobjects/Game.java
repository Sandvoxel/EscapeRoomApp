package dev.trainwreck.escaperoomapp.data.gameobjects;


import dev.trainwreck.escaperoomapp.data.ClueData;
import javafx.collections.ObservableList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.FilenameFilter;
import java.util.List;
import java.util.UUID;

public class Game {

    private UUID gameId;
    private String gameName;
    private List<Room> rooms;
    private ClueData clueData;


    public Game(String gameName) {
        this.gameId = UUID.randomUUID();
        this.clueData = new ClueData(gameName);
        this.gameName = gameName;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void saveGame(){
        clueData.saveClueData(gameName);
    }

    public void loadGameData(){
        clueData.loadClueData(gameName);
    }

    public void pickImage(){
        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
        chooser.setAcceptAllFileFilterUsed(false);
        int returnValue = chooser.showOpenDialog(null);

        System.out.println(returnValue);
    }

    public ObservableList getClueData() {
        return clueData.getObservableList();
    }

    public void setClueData(ObservableList clueData) {
        this.clueData.setObservableList(clueData);
    }
}
