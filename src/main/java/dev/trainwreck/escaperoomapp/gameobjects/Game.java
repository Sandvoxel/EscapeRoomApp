package dev.trainwreck.escaperoomapp.gameobjects;


import java.util.List;
import java.util.UUID;

public class Game {

    private UUID gameId;
    private String gameName;
    private List<Room> rooms;

    public Game(String gameName) {
        this.gameId = UUID.randomUUID();
        this.gameName = gameName;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }
}
