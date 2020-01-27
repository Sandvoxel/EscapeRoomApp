package dev.trainwreck.escaperoomapp.gameobjects;

import javax.swing.*;
import java.util.UUID;

public class Step {
    private UUID stepId;
    private String stepName;
    private boolean StepCompleted = false;

    public Step(String stepName) {
        this.stepId = UUID.randomUUID();
        this.stepName = stepName;
    }


    public String getStepName() {
        return stepName;
    }
}
