package dev.trainwreck.escaperoomapp.data.gameobjects;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomData {
    private UUID roomId;
    private String roomName;
    private List<StepData> stepData = new ArrayList<>();
    private JPanel stepsListPanel = new JPanel(new GridBagLayout());

    public RoomData(String roomName) {
        this.roomId = UUID.randomUUID();
        this.roomName = roomName;

        stepData.add(new StepData("john"));
        stepData.add(new StepData("doe"));
        stepsListPanel.setBackground(Color.WHITE);
    }

    public RoomData(String roomName, List<StepData> stepData) {
        this.roomId = UUID.fromString(roomName);
        this.roomName = roomName;
        this.stepData = stepData;
    }

}
