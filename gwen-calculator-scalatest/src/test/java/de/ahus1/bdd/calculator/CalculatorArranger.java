package de.ahus1.bdd.calculator;

import com.shazam.gwen.collaborators.Arranger;

public class CalculatorArranger implements Arranger {

    private final Calculator device;

    public CalculatorArranger(Calculator device) {
        this.device = device;
    }

    public CalculatorArranger isInitializedWith(long val) {
        device.set(val);
        return this;
    }

    public void turnedOn() {
        device.reset();
    }
}