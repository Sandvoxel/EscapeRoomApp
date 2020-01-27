package dev.trainwreck.escaperoomapp.gameobjects;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room {
    private UUID roomId;
    private String roomName;
    private List<Step> steps = new ArrayList<>();
    private JPanel stepsListPanel = new JPanel(new GridBagLayout());

    public Room(String roomName) {
        this.roomId = UUID.randomUUID();
        this.roomName = roomName;

        steps.add(new Step("john"));
        steps.add(new Step("doe"));
        stepsListPanel.setBackground(Color.WHITE);
    }

    public Room(String roomName, List<Step> steps) {
        this.roomId = UUID.fromString(roomName);
        this.roomName = roomName;
        this.steps = steps;
    }


    protected void updateStepsListPanel() {
        stepsListPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,2,0,10);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.gridx = 0; gbc.gridy = 0;
        steps.forEach(step -> {
            JLabel steplabel = new JLabel(step.getStepName());
            steplabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
            stepsListPanel.add(steplabel,gbc);
            gbc.gridy++;
        });

    }

    public JScrollPane getStepsListPanel(int width, int height) {
        updateStepsListPanel();
        JScrollPane scrollPane = new JScrollPane(stepsListPanel);
        scrollPane.setPreferredSize(new Dimension(width,height));
        return scrollPane;
    }

    public JPanel createStepJpanel(){
        JPanel roomStepInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        roomStepInput.setBackground(Color.WHITE);
        JTextField stepField = new JTextField();
        stepField.setPreferredSize(new Dimension(100,50));

        JButton inputStep = new JButton();

        inputStep.addActionListener(e -> {
            steps.add(new Step(stepField.getText()));
            updateStepsListPanel();
            SwingUtilities.updateComponentTreeUI(roomStepInput.getParent());
            stepField.setText("");
        });
        gbc.gridx = 0; gbc.gridy = 0;
        roomStepInput.add(stepField,gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        roomStepInput.add(inputStep,gbc);


        return roomStepInput;
    }
}
