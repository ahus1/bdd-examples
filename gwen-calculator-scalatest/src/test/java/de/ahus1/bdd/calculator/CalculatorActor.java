package de.ahus1.bdd.calculator;

import com.shazam.gwen.collaborators.Actor;

public class CalculatorActor implements Actor {

    private final Calculator device;

    public CalculatorActor(Calculator device) {
        this.device = device;
    }

    public CalculatorActor adds(long val) {
        device.add(val);
        return this;
    }

    public CalculatorActor multipliesBy(long val) {
        device.multiplyBy(val);
        return this;
    }

    public CalculatorActor powerBy(long val) {
        device.power(val);
        return this;
    }

}

