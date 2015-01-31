package de.ahus1.bdd.calculator;
import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorSUT implements
        Given<CalculatorArranger>,
        When<CalculatorActor>,
        Then<CalculatorAsserter> {

    private Calculator device;

    private CalculatorArranger arranger;
    private CalculatorActor actor;
    private CalculatorAsserter asserter;

    public CalculatorSUT() {
        device = new Calculator();
        arranger = new CalculatorArranger(device);
        actor = new CalculatorActor(device);
        asserter = new CalculatorAsserter(device);
    }

    public CalculatorArranger given() {
        return arranger;
    }

    public CalculatorActor when() {
        return actor;
    }

    public CalculatorAsserter then() {
        return asserter;
    }


}
