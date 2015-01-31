package de.ahus1.bdd.calculator;

import com.shazam.gwen.collaborators.Asserter;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorAsserter implements Asserter {

    private final Calculator device;

    public CalculatorAsserter(Calculator device) {
        this.device = device;
    }

    public void shows(long val) {
        assertThat(device.getState()).isEqualTo(val);
    }

}