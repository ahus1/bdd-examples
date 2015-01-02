package de.ahus1.bdd.testng.calculator;

import com.shazam.gwen.collaborators.Actor;
import com.shazam.gwen.collaborators.Arranger;
import com.shazam.gwen.collaborators.Asserter;
import com.shazam.gwen.gwt.Given;
import com.shazam.gwen.gwt.Then;
import com.shazam.gwen.gwt.When;
import de.ahus1.bdd.calculator.Calculator;

import static org.fest.assertions.Assertions.assertThat;

public class CalculatorSUT implements Given<CalculatorSUT.CalculatorArranger>,
        When<CalculatorSUT.CalculatorActor>, Then<CalculatorSUT.CalculatorAsserter> {

    private Calculator device = new Calculator();

    private CalculatorArranger arranger;
    private CalculatorActor actor;
    private CalculatorAsserter asserter;

    public class CalculatorAsserter implements Asserter {

        public void shows(long val) {
            assertThat(device.getState()).isEqualTo(val);
        }

    }

    public class CalculatorArranger implements Arranger {

        public CalculatorArranger isInitializedWith(long val) {
            device.set(val);
            return this;
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

    public CalculatorSUT() {
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

}
