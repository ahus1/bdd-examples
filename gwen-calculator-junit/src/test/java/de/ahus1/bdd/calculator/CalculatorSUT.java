package de.ahus1.bdd.calculator;

// tag::calcsut[]

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorSUT implements
        Given<CalculatorSUT.CalculatorArranger>,
        When<CalculatorSUT.CalculatorActor>,
        Then<CalculatorSUT.CalculatorAsserter> {

    private Calculator device;

    private CalculatorArranger arranger;
    private CalculatorActor actor;
    private CalculatorAsserter asserter;

    public CalculatorSUT() {
        device = new Calculator();
        arranger = new CalculatorArranger();
        actor = new CalculatorActor();
        asserter = new CalculatorAsserter();
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

    public class CalculatorArranger implements Arranger {

        // end::calcsut[]
        public CalculatorArranger isInitializedWith(long val) {
            device.set(val);
            return this;
        }

        // tag::calcsut[]
        public void turnedOn() {
            device.reset();
        }
    }

    public class CalculatorActor implements Actor {

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

    public class CalculatorAsserter implements Asserter {

        public void shows(long val) {
            assertThat(device.getState()).isEqualTo(val);
        }

    }
}
// end::calcsut[]
